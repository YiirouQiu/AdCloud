package org.AdCloud.ad.constant;

import lombok.Getter;

@Getter
public enum CommonStatus {

    VALID(1, "Valid Status"),
    INVALID(0, "Invalid Status");

    private Integer status;

    private String description;

    CommonStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
