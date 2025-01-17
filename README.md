# PeerBanHelper

自动封禁不受欢迎、吸血和异常的 BT 客户端，并支持自定义规则。

> [!NOTE]
> PeerBanHelper 没有内建的更新检查程序，记得时常回来看看是否有新的版本更新，或者 Watch 本仓库以接收版本更新通知  
> QQ 交流群：932978658，如果在使用过程中需要帮助，您可以在这里和他人一同交流。或者在 [Issue Tracker](https://github.com/Ghost-chu/PeerBanHelper/issues) 打开新问题

> [!TIP]
> 您只需要正确连接 PBH 到下载器就可以正常工作，大多数情况下，并不需要额外配置

> [!TIP]
> 为获得最佳效果，建议配合我们维护的 IP 规则库 [PBH-BTN/BTN-Collected-Rules](https://github.com/PBH-BTN/BTN-Collected-Rules) 和 [BTN 网络](https://github.com/PBH-BTN/PeerBanHelper/wiki/BTN-%E7%BD%91%E7%BB%9C) 一起食用，不过这是完全可选的。

| 主界面                                                                                                                                   | 封禁列表                                                                                                                                 | 封禁日志                                                                                                                                 | 封禁统计                                                                                                                                | 规则统计                                                                                                                                    | 规则订阅                                                                                                                                    |
|---------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| <img width="1280" alt="homepage" src="https://github.com/PBH-BTN/PeerBanHelper/assets/19235246/d7f7ea9f-70df-40f1-a782-260450972bc9"> | <img width="1280" alt="banlist" src="https://github.com/PBH-BTN/PeerBanHelper/assets/19235246/c3e139e6-eb82-423f-b083-1839713ec801"> | <img width="1280" alt="banlogs" src="https://github.com/PBH-BTN/PeerBanHelper/assets/19235246/00d8efcc-0dd7-4e05-bdeb-9444e14739d6"> | <img width="1280" alt="maxban" src="https://github.com/PBH-BTN/PeerBanHelper/assets/30802565/ae78ebb9-67f7-481a-9afc-7ced2c6a2534"> | <img width="1280" alt="banMetrics" src="https://github.com/PBH-BTN/PeerBanHelper/assets/19235246/9e4cd7b7-aaff-4b66-8d1d-ad4ef3466b1f"> | <img width="1280" alt="banMetrics" src="https://github.com/PBH-BTN/PeerBanHelper/assets/19235246/dc312186-9643-4f23-9d53-7b8e0852f228"> |

## 安装 PeerBanHelper

查看 [PeerBanHelper 文档](https://pbh-btn.github.io/pbh-docs/docs/category/%E5%AE%89%E8%A3%85%E9%83%A8%E7%BD%B2)

## 支持的客户端

* qBittorrent
* BiglyBT（需要安装[插件](https://github.com/PBH-BTN/PBH-Adapter-BiglyBT)）
* Deluge（需要安装[插件](https://github.com/PBH-BTN/PBH-Adapter-Deluge)）
* Azureus(Vuze)（需要安装[插件](https://github.com/PBH-BTN/PBH-Adapter-Azureus)）
* Transmission **(3.00-20 或更高版本，不建议使用)**

## 注意事项

请不要打开下载器中的 "允许来自同一 IP 地址的多个连接" 选项，这会干扰 PBH 计算数据，并导致错误封禁。
  
## 功能介绍

PeerBanHelper 主要由以下几个功能模块组成：

* [PeerID 黑名单](https://pbh-btn.github.io/pbh-docs/docs/module/peer-id)
* [Client Name 黑名单](https://pbh-btn.github.io/pbh-docs/docs/module/client-name)
* [IP/GeoIP/IP类型 黑名单](https://pbh-btn.github.io/pbh-docs/docs/module/ip-address-blocker)
* [虚假进度检查器（提供启发式客户端检测功能）](https://pbh-btn.github.io/pbh-docs/docs/module/progress-cheat-blocker)
* [自动连锁封禁](https://pbh-btn.github.io/pbh-docs/docs/module/auto-range-ban)
* [多拨追猎](https://pbh-btn.github.io/pbh-docs/docs/module/multi-dial)
* Peer ID/Client Name 伪装检查；通过 [AviatorScript 引擎](https://pbh-btn.github.io/pbh-docs/docs/module/expression-engine) 实现
* [主动监测（提供本地数据分析功能）](https://pbh-btn.github.io/pbh-docs/docs/module/active-monitoring)
* [网络 IP 集规则订阅](https://pbh-btn.github.io/pbh-docs/docs/module/ip-address-blocker-rules)
* WebUI （目前支持：活跃封禁名单查看，历史封禁查询，封禁最频繁的 Top 50 IP，规则订阅管理，图表查看，Peer 列表查看）

此外，PeerBanHelper 会在启动时下载 GeoIP 库，成功加载后支持以下功能：

* 在封禁列表中查看 IP 归属地，AS 信息（ASN、ISP、AS名称等），网络类型信息（宽带、基站、物联网、数据中心等）
* 基于 GeoIP 信息按国家/地区、城市、网络类型、ASN 等封禁 IP 地址
* 查看 GeoIP 统计数据

## 常见问题

在报告问题前，请先检查 [常见问题列表](https://pbh-btn.github.io/pbh-docs/docs/faq)

## Install4j

PeerBanHelper 使用 [Install4j multi-platform installer builder](https://www.ej-technologies.com/products/install4j/overview.html) 打包多平台安装程序。感谢 ej-technolgies 的开放源代码许可证。点击链接或者下面的图片下载 install4j。

[![Install4j](https://www.ej-technologies.com/images/product_banners/install4j_large.png)](https://www.ej-technologies.com/products/install4j/overview.html)

## Credit

* [Cordelia](https://github.com/bochkov/cordelia)
* [IPAddress](https://github.com/seancfoley/IPAddress)
* [YamlConfiguration](https://github.com/bspfsystems/YamlConfiguration)
* [libby](https://github.com/AlessioDP/libby)
* [AviatorScript](https://github.com/killme2008/aviatorscript)
* [javalin](https://javalin.io/)
* [deluge-java](https://github.com/RangerRick/deluge-java)
