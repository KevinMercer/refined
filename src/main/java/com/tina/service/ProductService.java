/**
 * @File ProductService.java
 * @Type ProductService
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.Product;
import com.tina.entity.ProductExample;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午4:31:30
 * 
 */
public interface ProductService {
	
	List<Product> queryProductPage(Map<String, Object> map);
	
	List<Product> queryProductExtract();
	
	List<Product> queryProductExample(ProductExample productExample);
	
	Product queryProductByPrimaryKey(Integer product_id);
	
	int addProduct(Product product);
	
	int modifyProductByPrimaryKey(Product product);
	
	int removeProduct(Integer[] product_ids);
	
	int countProduct(Map<String, Object> map);
	
	int putStorage(Map<String, Object> map);
	
	int extractApprove(Map<String, Object> map);

}
