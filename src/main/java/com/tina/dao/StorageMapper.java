package com.tina.dao;

import com.tina.entity.Storage;
import com.tina.entity.StorageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    long countByExample(StorageExample example);
    
    int countStorageLog(Map<String, Object> map);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer storage_no);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);
    
    List<Map<String, Object>> selectStorageLog(Map<String, Object> map);

    Storage selectByPrimaryKey(Integer storage_no);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}