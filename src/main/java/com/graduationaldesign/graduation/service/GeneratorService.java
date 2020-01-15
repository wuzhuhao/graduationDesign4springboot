package com.graduationaldesign.graduation.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GeneratorService {
    List<Map<String, Object>> list();

    byte[] generatorCode(String[] tableNames);
}
