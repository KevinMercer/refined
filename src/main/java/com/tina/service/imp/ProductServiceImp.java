/**
 * @File ProductServiceImp.java
 * @Type ProductServiceImp
 */
package com.tina.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.ExtractMapper;
import com.tina.dao.ProductMapper;
import com.tina.dao.StorageMapper;
import com.tina.entity.Extract;
import com.tina.entity.Product;
import com.tina.entity.ProductExample;
import com.tina.entity.Storage;
import com.tina.service.ProductService;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午4:36:39
 * 
 */
@Service
public class ProductServiceImp implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Resource
	private StorageMapper storageMapper;
	@Resource
	private ExtractMapper extractMapper;
	private Storage storage;
	private Extract extract;
	private List<Integer> product_ids;
	private Product product;
	private int product_id, put;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#queryProductPage(java.util.Map)
	 */
	@Override
	public List<Product> queryProductPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productMapper.selectProductPage(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#queryProductExtract(com.tina.entity.
	 * ProductExample)
	 */
	@Override
	public List<Product> queryProductExtract() {
		// TODO Auto-generated method stub
		return productMapper.selectEnableProduct();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#queryProductByPrimaryKey(java.lang.
	 * Integer)
	 */
	@Override
	public Product queryProductByPrimaryKey(Integer product_id) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(product_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#addProduct(com.tina.entity.Product)
	 */
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.insertSelective(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.ProductService#modifyProductByPrimaryKey(com.tina.entity
	 * .Product)
	 */
	@Override
	public int modifyProductByPrimaryKey(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#removeProduct(java.lang.Integer[])
	 */
	@Override
	public int removeProduct(Integer[] product_ids) {
		// TODO Auto-generated method stub
		if (product_ids == null || product_ids.length <= 0) {
			return 0;
		}
		this.product_ids = new ArrayList<Integer>();
		for (int i = 0; i < product_ids.length; i++) {
			this.product_ids.add(product_ids[i]);
		}
		return productMapper.deleteProductBatch(this.product_ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.ProductService#countProduct(com.tina.entity.
	 * ProductExample)
	 */
	@Override
	public int countProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productMapper.countProduct(map);
	}

	@Override
	public int putStorage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		storage = new Storage();
		product_id = (int) map.get("product_id");
		put = (int) map.get("put");
		storage.setProduct_id(product_id);
		storage.setNumber(put);
		storage.setStorage_date(new Date());
		storage.setOperator((int) map.get("operator"));
		product = productMapper.selectByPrimaryKey(product_id);
		put += product.getRepository();
		product.setRepository(put);
		storageMapper.insertSelective(storage);
		return productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public int extractApprove(Map<String, Object> map) {
		extract = new Extract();
		extract.setApprove((Integer) map.get("approve"));
		extract.setEmpno((Integer) map.get("empno"));
		extract.setProduct_id((Integer) map.get("product_id"));
		extract.setApprove_describe((String) map.get("describe"));
		extract.setApprove_status((Integer) map.get("status"));
		extract.setExtract((Integer) map.get("extract"));
		extract.setExtract_date((Date) map.get("extract_date"));
		extract.setCopy((Integer) map.get("copy"));
		extractMapper.insertSelective(extract);
		return 2;
	}

	@Override
	public List<Product> queryProductExample(ProductExample productExample) {
		return productMapper.selectByExample(productExample);
	}

}
