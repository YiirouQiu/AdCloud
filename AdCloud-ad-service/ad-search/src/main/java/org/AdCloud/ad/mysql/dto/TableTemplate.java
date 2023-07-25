package org.AdCloud.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AdCloud.ad.mysql.constant.OpType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTemplate {

    private String tableName;

    private String level;

    private Map<OpType, List<String>> opTypeFieldSetMap = new HashMap<>();

    private Map<Integer, String> posMap = new HashMap<>();
}
