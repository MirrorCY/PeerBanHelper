package com.ghostchu.peerbanhelper.database.dao.impl;

import com.ghostchu.peerbanhelper.database.Database;
import com.ghostchu.peerbanhelper.database.dao.AbstractPBHDao;
import com.ghostchu.peerbanhelper.database.table.PeerRecordEntity;
import com.ghostchu.peerbanhelper.database.table.TorrentEntity;
import com.ghostchu.peerbanhelper.wrapper.PeerWrapper;
import com.ghostchu.peerbanhelper.wrapper.TorrentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class PeerRecordDao extends AbstractPBHDao<PeerRecordEntity, Long> {
    private final TorrentDao torrentDao;

    public PeerRecordDao(@Autowired Database database, TorrentDao torrentDao) throws SQLException {
        super(database.getDataSource(), PeerRecordEntity.class);
        this.torrentDao = torrentDao;
        setObjectCache(true);
    }

    public void syncPendingTasks(List<BatchHandleTasks> tasks) throws SQLException {
        callBatchTasks(() -> {
            tasks.forEach(t -> {
                try {
                    writeToDatabase(t.downloader, t.torrent, t.peer);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            return null;
        });
    }

    private int writeToDatabase(String downloader, TorrentWrapper torrent, PeerWrapper peer) throws SQLException {
        TorrentEntity torrentEntity = torrentDao.createIfNotExists(new TorrentEntity(
                null,
                torrent.getHash(),
                torrent.getName(),
                torrent.getSize()
        ));
        PeerRecordEntity currentSnapshot = new PeerRecordEntity(
                null,
                peer.toPeerAddress().getAddress().toNormalizedString(),
                torrentEntity,
                downloader,
                peer.getId().length() > 8 ? peer.getId().substring(0, 8) : peer.getId(),
                peer.getClientName(),
                peer.getUploaded(),
                peer.getUploaded(),
                peer.getDownloaded(),
                peer.getDownloaded(),
                peer.getFlags(),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
        );
        PeerRecordEntity databaseSnapshot = createIfNotExists(currentSnapshot);
        long downloadedIncremental = peer.getDownloaded() - databaseSnapshot.getDownloadedOffset();
        long uploadedIncremental = peer.getUploaded() - databaseSnapshot.getUploadedOffset();
        if (downloadedIncremental < 0 || uploadedIncremental < 0) {
            databaseSnapshot.setDownloaded(databaseSnapshot.getDownloaded() + peer.getDownloaded());
            databaseSnapshot.setUploaded(databaseSnapshot.getUploaded() + peer.getUploaded());
        } else {
            databaseSnapshot.setDownloaded(databaseSnapshot.getDownloaded() + downloadedIncremental);
            databaseSnapshot.setUploaded(databaseSnapshot.getUploaded() + uploadedIncremental);
        }
        // 更新 offset，转换为增量数据
        databaseSnapshot.setDownloadedOffset(peer.getDownloaded());
        databaseSnapshot.setUploadedOffset(peer.getUploaded());
        databaseSnapshot.setPeerId(currentSnapshot.getPeerId());
        databaseSnapshot.setClientName(currentSnapshot.getClientName());
        databaseSnapshot.setLastFlags(currentSnapshot.getLastFlags());
        databaseSnapshot.setLastTimeSeen(currentSnapshot.getLastTimeSeen());
        return update(databaseSnapshot);
    }

    @Override
    public synchronized PeerRecordEntity createIfNotExists(PeerRecordEntity data) throws SQLException {
        PeerRecordEntity existing = queryBuilder().where()
                .eq("address", data.getAddress())
                .and()
                .eq("torrent_id", data.getTorrent().getId())
                .and()
                .eq("downloader", data.getDownloader())
                .queryForFirst();
        if (existing == null) {
            create(data);
            return data;
        } else {
            return existing;
        }
    }

    public record BatchHandleTasks(String downloader, TorrentWrapper torrent, PeerWrapper peer) {

    }

}
