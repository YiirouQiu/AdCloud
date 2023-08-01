package org.AdCloud.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {
    // application code
    private String appCode;
    // the name of the application
    private String appName;
    // package name
    private String packageName;
    // activity name
    private String activityName;
}
