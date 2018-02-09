package com.hei2hei.wx_project.web;

import com.hei2hei.wx_project.entity.Area;
import com.hei2hei.wx_project.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value="/area",method = RequestMethod.GET)
    public Map<String,Object> queryArea(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> list = areaService.queryArea();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value="/area/{id}",method = RequestMethod.GET)
    public Map<String,Object> queryAreaById(@PathVariable("id") Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value="/area",method = RequestMethod.PUT)
    public Map<String,Object> insertArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = areaService.insertArea(area);
        modelMap.put("success",result);
        return modelMap;
    }

    @RequestMapping(value="/area",method = RequestMethod.PATCH)
    public Map<String,Object> updataArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = areaService.updateArea(area);
        modelMap.put("success",result);
        return modelMap;
    }

    @RequestMapping(value="/area/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteArea(@PathVariable("id") Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = areaService.deleteArea(areaId);
        modelMap.put("success",result);
        return modelMap;
    }
}
