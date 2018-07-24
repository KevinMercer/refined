package com.tina.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tina.entity.AdvancedDeptinfo;
import com.tina.entity.Deptinfo;
import com.tina.entity.DeptinfoExample;

public interface DeptinfoMapper {
    long countByExample(DeptinfoExample example);
    
    int countDept(Map<String, Object> map);

    int deleteByExample(DeptinfoExample example);

    int deleteByPrimaryKey(Integer deptno);
    
    int deleteDeptinfoBatch(List<Integer> deptnos);

    int insert(Deptinfo record);

    int insertSelective(Deptinfo record);

    List<Deptinfo> selectByExample(DeptinfoExample example);
    
    List<AdvancedDeptinfo> selectDeptinfoPage(Map<String, Object> map);

    Deptinfo selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") Deptinfo record, @Param("example") DeptinfoExample example);

    int updateByExample(@Param("record") Deptinfo record, @Param("example") DeptinfoExample example);

    int updateByPrimaryKeySelective(Deptinfo record);

    int updateByPrimaryKey(Deptinfo record);
}