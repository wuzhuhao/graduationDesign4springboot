package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Diary;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 21:54
 */

public interface DiaryService {
    PageBean<Diary> listByPage(int uid, int page);

}
