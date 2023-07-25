package org.AdCloud.ad.constant;

public enum CreativeType {

    IMAGE(1, "picture"),
    VIDEO(2, "video"),
    TEXT(3, "plain text");

    private Integer status;

    private String description;

    CreativeType(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
