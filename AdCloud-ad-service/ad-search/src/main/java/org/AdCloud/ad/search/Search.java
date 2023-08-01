package org.AdCloud.ad.search;

import org.AdCloud.ad.search.vo.SearchRequest;
import org.AdCloud.ad.search.vo.SearchResponse;

public interface Search {

    SearchResponse fetchAds(SearchRequest request);
}
