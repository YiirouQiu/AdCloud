package org.AdCloud.ad.index.keyword;

import lombok.extern.slf4j.Slf4j;
import org.AdCloud.ad.index.IndexAware;
import org.AdCloud.ad.utils.CommonUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {

    // search from keyword --> unit
    private static Map<String, Set<Long>> keywordUnitMap;

    // search from unit --> keyword
    private static Map<Long, Set<String>> unitKeywordMap;

    static {
        keywordUnitMap = new ConcurrentHashMap<>();
        unitKeywordMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {

        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }
        Set<Long> result = keywordUnitMap.get(key);
        if (result == null) {
            return Collections.emptySet();
        }

        return result;
    }

    @Override
    public void add(String key, Set<Long> value) {

        log.info("UnitKeywordIndex, before add: {}", unitKeywordMap);

        Set<Long> unitIdSet = CommonUtils.getOrCreate(
                key, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIdSet.addAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getOrCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.add(key);
        }

        log.info("UnitKeywordIndex, after add: {}", unitKeywordMap);
    }

    // not supported.
    @Override
    public void update(String key, Set<Long> value) {

        log.error("keyword index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before delete: {}", unitKeywordMap);

        Set<Long> unitIds = CommonUtils.getOrCreate(
                key, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.removeAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getOrCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.remove(key);
        }

        log.info("UnitKeywordIndex, after delete: {}", unitKeywordMap);
    }

    public boolean match(Long unitId, List<String> keywords) {
        if (unitKeywordMap.containsKey(unitId)
                && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))) {

            Set<String> unitKeywords = unitKeywordMap.get(unitId);

            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }

        return false;
    }
}
