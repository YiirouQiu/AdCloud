package org.AdCloud.ad.service.impl;

import org.AdCloud.ad.dao.CreativeRepository;
import org.AdCloud.ad.entity.Creative;
import org.AdCloud.ad.service.CreativeService;
import org.AdCloud.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl implements CreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative newCreative = creativeRepository.save(request.convertToEntity());
        return new CreativeResponse(newCreative.getId(), newCreative.getName());
    }
}
