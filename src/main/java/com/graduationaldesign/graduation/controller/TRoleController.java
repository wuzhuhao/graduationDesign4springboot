package com.graduationaldesign.graduation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.graduationaldesign.graduation.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.graduationaldesign.graduation.util.ResponseUtil;
import com.graduationaldesign.graduation.dto.LimitShowDTO;
import com.graduationaldesign.graduation.dto.TRoleDTO;
import com.graduationaldesign.graduation.service.ITRoleService;


@RestController
@RequestMapping("/api/tRole")
public class TRoleController {
    @Autowired
    private ITRoleService tRoleService;
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ResponseEntity<String> list(
//        @Validated
//        LimitShowDTO limitShowDTO, BindingResult errors) {
//        if(errors.hasErrors())
//            return ResponseUtil.getResponseEntityWhenInvalidReqParams();
//
//        Map<String, Object> result = new HashMap<String, Object>();
//
//        List<Map<String, Object>> tRoleList = tRoleService.loadMaps(null, null, null, null, limitShowDTO.getCurPage(), limitShowDTO.getLimit());
//        long count = tRoleService.count();
//
//        result.put("rows", tRoleList);
//        result.put("total", count);
//
//        return ResponseUtil.getResEntityForGetAndJson(result);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<String> show(@PathVariable("id") Long id) {
//        Map<String, Object> tRoleModel = tRoleService.findMap(id);
//
//        return ResponseUtil.getResEntityForGetAndJson(tRoleModel);
//    }
//
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ResponseEntity<String> create(
//        @Validated
//        TRoleDTO tRoleDTO, BindingResult errors) {
//        if(errors.hasErrors())
//            return ResponseUtil.getResponseEntityWhenInvalidReqParams();
//
//        Role tRoleModel = tRoleDTO.toModel();
//
//        return ResponseUtil.getResEntityForPPP(tRoleService.save(tRoleModel));
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<String> update(@PathVariable("id") Long id,
//        @Validated
//        TRoleDTO tRoleDTO, BindingResult errors) {
//
//        Role tRoleModel = tRoleDTO.toModel();
//        tRoleModel.setId(id);
//        return ResponseUtil.getResEntityForPPP(tRoleService.update(tRoleModel));
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> destory(@PathVariable("id") Long id) {
//        return ResponseUtil.getResEntityForDel(tRoleService.delete(id));
//    }
//
//    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deletes(@RequestParam("primaryKeys") Long[] primaryKeys) {
//        return ResponseUtil.getResEntityForDel(tRoleService.batchDelete(primaryKeys));
//    }
}
