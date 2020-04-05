package com.graduationaldesign.graduation.pojo;

import java.io.Serializable;

/**
 * 用于抽象三种用户通用行为
 *
 * @Author: wuzhuhao
 * @Date: 2020/4/5 0005 12:24
 */
public interface User extends Serializable {
    String findUserName();

    String findUserType();
}
