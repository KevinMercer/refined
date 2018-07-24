/**
 * @File RepositoryController.java
 * @Type RepositoryController
 */
package com.tina.controllers;

import java.util.Calendar;
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
import com.tina.entity.Product;
import com.tina.entity.Storage;
import com.tina.entity.StorageExample;
import com.tina.entity.StorageExample.Criteria;
import com.tina.service.ProductService;
import com.tina.service.RepositoryService;
import com.tina.util.BootstrapTable;
import com.tina.util.Message;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午10:33:37
 * 
 */
@Controller
@RequestMapping("/repository/")
public class RepositoryController {

	@Resource
	private RepositoryService repositoryService;
	@Resource
	private ProductService productService;
	private BootstrapTable<Map<String, Object>> mapBootstrapTable;
	private List<Map<String, Object>> maps;
	private List<Product> products;
	private Map<String, Object> map;
	private int pageNumber, pageSize, counts;
	private Message message;

	@RequestMapping("storageList")
	private synchronized String storageList() {
		return "repository/storageLog";
	}

	@RequestMapping("storageData")
	@ResponseBody
	private synchronized BootstrapTable<Map<String, Object>> storageData(Integer pageNumber, Integer pageSize, String searchStr) {
		mapBootstrapTable = new BootstrapTable<Map<String, Object>>();
		map = new HashMap<String, Object>();
		map.put("key", searchStr);
		counts = repositoryService.countStorageLog(map);
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
		maps = repositoryService.queryStorageLog(map);
		mapBootstrapTable.setRows(maps);
		mapBootstrapTable.setTotal(counts);
		return mapBootstrapTable;
	}

	@RequestMapping("repositoryManage")
	private synchronized String repositoryManage() {
		return "repository/repositoryManage";
	}

	@RequestMapping("approveList")
	private synchronized String approveManage() {
		return "repository/approveList";
	}

	@RequestMapping("approveData")
	@ResponseBody
	private synchronized BootstrapTable<Map<String, Object>> approveData(HttpSession session) {
		mapBootstrapTable = new BootstrapTable<Map<String, Object>>();
		Empinfo empinfo = (Empinfo) session.getAttribute("account");
		maps = repositoryService.queryApprove(empinfo.getEmpno());
		counts = repositoryService.countApprove(empinfo.getEmpno());
		mapBootstrapTable.setRows(maps);
		mapBootstrapTable.setTotal(counts);
		return mapBootstrapTable;
	}

	@RequestMapping("reportProduct")
	private synchronized String reportProduct(HttpServletRequest request) {
		products = productService.queryProductExtract();
		request.setAttribute("product", products);
		return "repository/reportProduct";
	}

	@RequestMapping("report")
	@ResponseBody
	private synchronized Message report(Integer product_id) {
		StorageExample storageExample = new StorageExample();
		Criteria criteria = storageExample.createCriteria();
		Calendar cal_1 = Calendar.getInstance();
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, 0);
		//criteria.andStorage_dateBetween(cal_1.getTime(), cale.getTime());
		criteria.andProduct_idEqualTo(product_id);
		List<Storage> storages = repositoryService.queryStorageExample(storageExample);
		message = new Message();
		int effectRow = 0;
		System.err.println("safasfasf" + storages);
		for (Storage storage : storages) {
			effectRow += storage.getNumber();
		}
		message.setEffectRow(effectRow);
		return message;
	}

}
