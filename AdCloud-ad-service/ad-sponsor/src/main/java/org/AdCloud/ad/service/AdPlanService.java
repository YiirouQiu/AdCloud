package org.AdCloud.ad.service;

import org.AdCloud.ad.entity.AdPlan;
import org.AdCloud.ad.exception.AdException;
import org.AdCloud.ad.vo.AdPlanGetRequest;
import org.AdCloud.ad.vo.AdPlanRequest;
import org.AdCloud.ad.vo.AdPlanResponse;

import java.util.List;

@SuppressWarnings("all")
public interface AdPlanService {

    /**
     * create new plan
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * retrieve plans
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * plan update
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * plan deletion
     * @param request
     * @return void
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;


}
