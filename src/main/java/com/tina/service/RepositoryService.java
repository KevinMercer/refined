/**
 * @File RepositoryService.java
 * @Type RepositoryService
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.Storage;
import com.tina.entity.StorageExample;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午10:27:00
 * 
 */
public interface RepositoryService {

	List<Map<String, Object>> queryStorageLog(Map<String, Object> map);

	int countStorageLog(Map<String, Object> map);

	List<Map<String, Object>> queryApprove(Integer id);
	
	List<Storage> queryStorageExample(StorageExample storageExample);
	
	int countApprove(Integer id);

}
