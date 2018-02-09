package com.hei2hei.wx_project.dao;

import com.hei2hei.wx_project.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 查询所有区域
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据id查询区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 新增区域信息
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 修改区域信息
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 根据id删除区域
     * @param areaId
     * @return
     */
    int deleteArea(Integer areaId);
}
