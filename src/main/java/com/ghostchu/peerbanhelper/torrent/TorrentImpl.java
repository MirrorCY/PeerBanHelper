package com.ghostchu.peerbanhelper.torrent;

import lombok.Setter;

@Setter
public class TorrentImpl implements Torrent {
    private String id;
    private String name;
    private long size;
    private long downloaded;

    public TorrentImpl(String id, String name, long size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }


}
