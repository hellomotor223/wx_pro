package com.hei2hei.wx_project.service.impl;

import com.hei2hei.wx_project.dao.AreaDao;
import com.hei2hei.wx_project.entity.Area;
import com.hei2hei.wx_project.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    @Transactional
    public boolean insertArea(Area area) {
        if(area.getAreaName()!=null && !"".equals(area.getAreaName())){
            Date time = new Date();
            area.setCreateTime(time);
            area.setLastEditTime(time);
            try {
                int row = areaDao.insertArea(area);
                if(row>0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败："+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean updateArea(Area area) {
        if(area.getAreaId()!=null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try {
                int row = areaDao.updateArea(area);
                if(row>0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域id不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(Integer areaId) {
        if(areaId!=null && areaId>0){
            try {
                int row = areaDao.deleteArea(areaId);
                if(row>0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败："+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域id不能为空！");
        }
    }
}
