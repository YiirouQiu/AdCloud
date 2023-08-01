package org.AdCloud.ad.index;


import lombok.Getter;

@Getter
public enum CommonStatus {
    VALID(1, "valid stauts"),
    INVALID(0, "invalid status");

    private int status;

    private String comment;

    CommonStatus(int status, String comment) {
        this.status = status;
        this.comment = comment;
    }
}
