package com.hei2hei.wx_project.dao;

import com.hei2hei.wx_project.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() throws Exception {
        List<Area> list = areaDao.queryArea();
        assertEquals(2,list.size());
    }

    @Test
    @Ignore
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(2);
        assertEquals("北苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setPriority(22);
        area.setCreateTime(new Date());
        int row = areaDao.insertArea(area);
        assertEquals(1,row);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaId(3);
        area.setAreaName("南苑");
        area.setLastEditTime(new Date());

        int row = areaDao.updateArea(area);
        assertEquals(1,row);
    }

    @Test
    public void deleteArea() throws Exception {
        int row = this.areaDao.deleteArea(3);
        assertEquals(1,row);
    }

}