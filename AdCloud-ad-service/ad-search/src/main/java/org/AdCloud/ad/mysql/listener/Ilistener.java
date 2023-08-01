package org.AdCloud.ad.mysql.listener;

import org.AdCloud.ad.mysql.dto.BinlogRowData;

public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
