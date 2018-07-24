package com.tina.dao;

import com.tina.entity.Empinfo;
import com.tina.entity.AdvancedEmpinfo;
import com.tina.entity.EmpinfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmpinfoMapper {
    long countByExample(EmpinfoExample example);

    int deleteByExample(EmpinfoExample example);

    int deleteByPrimaryKey(Integer empno);
    
    int deleteEmpinfoByDeptno(Integer deptno);
    
    int deleteEmpinfoBatch(List<Integer> empnos);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    List<Empinfo> selectByExample(EmpinfoExample example);
    
    List<AdvancedEmpinfo> selectEmpinfoByPage(Map<String, Object> map);

    Empinfo selectByPrimaryKey(Integer empno);
    
    AdvancedEmpinfo selectEmpinfoByDoubleKey(Map<String, Object> map);

    int updateByExampleSelective(@Param("record") Empinfo record, @Param("example") EmpinfoExample example);

    int updateByExample(@Param("record") Empinfo record, @Param("example") EmpinfoExample example);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);
}