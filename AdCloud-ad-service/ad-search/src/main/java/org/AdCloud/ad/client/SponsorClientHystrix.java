package org.AdCloud.ad.client;

import org.AdCloud.ad.client.vo.*;
import org.AdCloud.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * when getting procedure meets an error, return this SponsorClientHystrix
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
