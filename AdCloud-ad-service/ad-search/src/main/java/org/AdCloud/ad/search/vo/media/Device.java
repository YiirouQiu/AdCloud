package org.AdCloud.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * info regarding the advertisement device
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    // device id
    private String deviceCode;
    // mac
    private String mac;
    // ip
    private String ip;
    // the model of the machine
    private String model;
    // display size
    private String displaySize;

    private String screenSize;

    private String serialName;
}
