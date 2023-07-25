package org.AdCloud.ad.dao;

import org.AdCloud.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdUserRepository extends JpaRepository<AdUser, Long>,
                                        PagingAndSortingRepository<AdUser, Long> {
    AdUser findByUsername(String username);
}
