package org.AdCloud.ad.search.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AdCloud.ad.index.creative.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luwen.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

    public Map<String, List<Creative>> adSlot2Ads = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Creative {

        private Long adId;

        private String adUrl;

        private Integer width;

        private Integer height;

        private Integer type;

        private Integer materialType;

        // show the monitoring url
        private List<String> showMonitorUrl = Arrays.asList("www.AdCloud.com", "www.AdCloud.com");
        // click the monitored url
        private List<String> clickMonitorUrl = Arrays.asList("www.AdCloud.com", "www.AdCloud.com");
    }

    public static Creative convert(CreativeObject object) {

        Creative creative = new Creative();

        creative.setAdId(object.getAdId());

        creative.setAdUrl(object.getAdUrl());

        creative.setWidth(object.getWidth());

        creative.setHeight(object.getHeight());

        creative.setType(object.getType());

        creative.setMaterialType(object.getMaterialType());

        return creative;
    }
}
