package org.AdCloud.ad.sender;

import org.AdCloud.ad.mysql.dto.MySqlRowData;

public interface Sender {

    void sender(MySqlRowData rowData);
}
