package org.AdCloud.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AdCloud.ad.mysql.constant.OpType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySqlRowData {

    private String tableName;

    private String level;

    private OpType opType;

    private List<Map<String, String>> fieldValueMap = new ArrayList<>();
}
