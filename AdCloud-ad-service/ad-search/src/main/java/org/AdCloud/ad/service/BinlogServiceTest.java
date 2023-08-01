package org.AdCloud.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

public class BinlogServiceTest {

//    Write---------------
//    WriteRowsEventData{tableId=85, includedColumns={0, 1, 2}, rows=[
//    [10, 10, car]
//]}
//    Update--------------
//    UpdateRowsEventData{tableId=85, includedColumnsBeforeUpdate={0, 1, 2},
// includedColumns={0, 1, 2}, rows=[
//        {before=[10, 10, car], after=[10, 11, car]}
//]}
//    Delete--------------
//    DeleteRowsEventData{tableId=85, includedColumns={0, 1, 2}, rows=[
//    [11, 10, bike]
//]}


//    Write---------------
//    WriteRowsEventData{tableId=70, includedColumns={0, 1, 2, 3, 4, 5, 6, 7}, rows=[
//    [12, 10, plan, 1, Tue Jan 01 08:00:00 CST 2023, Tue Jan 01 08:00:00 CST 2023, Tue Jan 01 08:00:00 CST 2023, Tue Jan 01 08:00:00 CST 2023]
//]}


    public static void main(String[] args) throws Exception {

        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root",
                "1999"
        );
//        client.setBinlogFilename("binlog.000037");
//        client.setBinlogPosition();

        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update--------------");
                System.out.println(data);
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Write---------------");
                System.out.println(data);
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete--------------");
                System.out.println(data);
            }
        });

        client.connect();
    }
}
