package org.AdCloud.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdSlot {
    // the code of advertisement number
    private String adSlotCode;
    // type of position
    private Integer positionType;

    private Integer width;

    private Integer height;
    // advertisement type: e.g. picture, video ,etc
    private List<Integer> type;
    // lowest price of the advertisement
    private Integer minCpm;
}
