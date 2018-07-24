package com.tina.dao;

import com.tina.entity.Product;
import com.tina.entity.ProductExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);
    
    int countProduct(Map<String, Object> map);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer product_id);
    
    int deleteProductBatch(List<Integer> product_ids);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);
    
    List<Product> selectProductPage(Map<String, Object> map);
    
    List<Product> selectEnableProduct();

    Product selectByPrimaryKey(Integer product_id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}