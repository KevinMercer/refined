/**
 * @File ProductController.java
 * @Type ProductController
 */
package com.tina.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tina.entity.Empinfo;
import com.tina.entity.EmpinfoExample;
import com.tina.entity.EmpinfoExample.Criteria;
import com.tina.entity.Product;
import com.tina.service.EmpinfoService;
import com.tina.service.ProductService;
import com.tina.util.BootstrapTable;
import com.tina.util.Message;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午4:30:27
 * 
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

	@Resource
	private ProductService productService;
	@Resource
	private EmpinfoService empinfoService;
	private EmpinfoExample empinfoExample;
	private Criteria criteria;
	private List<Empinfo> empinfos;
	private BootstrapTable<Product> APbootstrapTable;
	private List<Product> products;
	private Product product;
	private Map<String, Object> map;
	private int effectRow, pageNumber, pageSize, counts;
	private Message message;

	@RequestMapping("productList")
	private synchronized String productList() {
		return "product/productList";
	}

	@RequestMapping("productData")
	@ResponseBody
	private synchronized BootstrapTable<Product> productData(Integer pageNumber, Integer pageSize, String searchStr) {
		APbootstrapTable = new BootstrapTable<Product>();
		map = new HashMap<String, Object>();
		map.put("key", searchStr);
		counts = productService.countProduct(map);
		this.pageNumber = pageNumber.intValue();
		this.pageSize = pageSize.intValue();
		if (pageNumber == null || pageNumber.intValue() <= 1) {
			this.pageNumber = 0;
		}
		if (pageSize == null || pageSize.intValue() <= 0) {
			this.pageSize = counts;
		}
		map.put("start", this.pageNumber);
		map.put("length", this.pageSize);
		products = productService.queryProductPage(map);
		APbootstrapTable.setRows(products);
		APbootstrapTable.setTotal(counts);
		return APbootstrapTable;
	}

	@RequestMapping("addProduct")
	private synchronized String addProduct() {
		return "product/productAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	private synchronized Message executeAdd(Product product) {
		message = new Message();
		effectRow = productService.addProduct(product);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("editProduct")
	private synchronized String editProduct(Integer product_id, HttpServletRequest request) {
		product = productService.queryProductByPrimaryKey(product_id);
		request.setAttribute("product", product);
		return "product/productEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody
	private synchronized Message executeEdit(Product product) {
		message = new Message();
		effectRow = productService.modifyProductByPrimaryKey(product);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("removeProduct")
	@ResponseBody
	private synchronized Message removeProduct(Integer[] product_ids) {
		message = new Message();
		effectRow = productService.removeProduct(product_ids);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("putStorage")
	private synchronized String putStorage(HttpServletRequest request) {
		products = productService.queryProductExtract();
		request.setAttribute("product", products);
		return "product/putStorage";
	}

	@RequestMapping("executePut")
	@ResponseBody
	private synchronized Message executePut(HttpSession session, Integer product_id, Integer put) {
		message = new Message();
		map = new HashMap<String, Object>();
		map.put("product_id", product_id);
		map.put("put", put);
		Empinfo empinfo = (Empinfo) session.getAttribute("account");
		map.put("operator", empinfo.getEmpno());
		effectRow = productService.putStorage(map);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("extractStorage")
	private synchronized String extractStorage(HttpServletRequest request) {
		empinfoExample = new EmpinfoExample();
		criteria = empinfoExample.createCriteria();
		criteria.andRoleidBetween(15, 19);
		empinfos = empinfoService.queryEmpinfo(empinfoExample);
		products = productService.queryProductExtract();
		request.setAttribute("empinfos", empinfos);
		request.setAttribute("product", products);
		return "product/extractStorage";
	}

	@RequestMapping("queryRepository")
	@ResponseBody
	private synchronized Message queryRepository(Integer product_id) {
		message = new Message();
		if (product_id == 0) {
			message.setEffectRow(0);
			return message;
		}
		product = productService.queryProductByPrimaryKey(product_id);
		message.setEffectRow(product.getRepository());
		return message;
	}

	@RequestMapping("executeExtract")
	@ResponseBody
	private synchronized Message executeExtract(HttpSession session, Integer product_id, String describe, Integer put, Integer copy) {
		message = new Message();
		Empinfo empinfo = (Empinfo) session.getAttribute("account");
		map = new HashMap<String, Object>();
		if (empinfo.getRoleid() >= 15 && empinfo.getRoleid() <= 19) {
			map.put("product_id", product_id);
			map.put("put", put * -1);
			map.put("operator", empinfo.getEmpno());
			effectRow = productService.putStorage(map);
		} else {
			map.put("empno", empinfo.getEmpno());
			map.put("product_id", product_id);
			map.put("approve", empinfo.getSuperior());
			map.put("status", 1);
			map.put("describe", describe);
			map.put("extract", put);
			map.put("extract_date", new Date());
			map.put("copy", copy);
			effectRow = productService.extractApprove(map);
		}
		message.setEffectRow(effectRow);
		return message;
	}

}
