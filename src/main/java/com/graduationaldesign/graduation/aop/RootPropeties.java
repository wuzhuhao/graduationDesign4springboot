package com.graduationaldesign.graduation.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/31 16:59
 */
@Component
@ConfigurationProperties(prefix = "root",ignoreUnknownFields = true)
public class RootPropeties {
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
