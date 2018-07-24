package com.tina.dao;

import com.tina.entity.Extract;
import com.tina.entity.ExtractExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ExtractMapper {
    long countByExample(ExtractExample example);
    
    int countApprove(Integer id);

    int deleteByExample(ExtractExample example);

    int deleteByPrimaryKey(Integer extract_no);

    int insert(Extract record);

    int insertSelective(Extract record);

    List<Extract> selectByExample(ExtractExample example);
    
    List<Map<String, Object>>  selectApprove(Integer id);

    Extract selectByPrimaryKey(Integer extract_no);

    int updateByExampleSelective(@Param("record") Extract record, @Param("example") ExtractExample example);

    int updateByExample(@Param("record") Extract record, @Param("example") ExtractExample example);

    int updateByPrimaryKeySelective(Extract record);

    int updateByPrimaryKey(Extract record);
}