package org.AdCloud.ad.search.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AdCloud.ad.search.vo.feature.*;
import org.AdCloud.ad.search.vo.media.AdSlot;
import org.AdCloud.ad.search.vo.media.App;
import org.AdCloud.ad.search.vo.media.Device;
import org.AdCloud.ad.search.vo.media.Geo;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private String mediaId;

    private RequestInfo requestInfo;

    private FeatureInfo featureInfo;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {
        private String requestId;
        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;

        private DistrictFeature districtFeature;

        private ItFeature itFeature;

        private FeatureRelation relation = FeatureRelation.AND;

    }

}
