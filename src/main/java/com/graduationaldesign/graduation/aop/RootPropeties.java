package com.graduationaldesign.graduation.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取全局参数
 *
 * @Author: wuzhuhao
 * @Date: 2020/1/31 16:59
 */
@Component
@ConfigurationProperties(prefix = "root", ignoreUnknownFields = true)
public class RootPropeties {

    private Integer pageSize;
    private String userAttribute;

    public String getUserAttribute() {
        return userAttribute;
    }

    public void setUserAttribute(String userAttribute) {
        this.userAttribute = userAttribute;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
