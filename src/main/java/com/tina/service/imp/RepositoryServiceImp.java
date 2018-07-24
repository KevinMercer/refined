/**
 * @File RepositoryServiceImp.java
 * @Type RepositoryServiceImp
 */
package com.tina.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.ExtractMapper;
import com.tina.dao.StorageMapper;
import com.tina.entity.Storage;
import com.tina.entity.StorageExample;
import com.tina.service.RepositoryService;

/**
 * @author 何悟隆
 * @datetime 2018年5月5日 下午10:28:33
 * 
 */
@Service
public class RepositoryServiceImp implements RepositoryService {
	
	@Resource
	private StorageMapper storageMapper;
	@Resource
	private ExtractMapper extractMapper;

	/**
	 * 
	 */
	public RepositoryServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.tina.service.RepositoryService#queryStorageLog(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> queryStorageLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storageMapper.selectStorageLog(map);
	}

	@Override
	public int countStorageLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storageMapper.countStorageLog(map);
	}

	@Override
	public List<Map<String, Object>> queryApprove(Integer id) {
		return extractMapper.selectApprove(id);
	}

	@Override
	public int countApprove(Integer id) {
		return extractMapper.countApprove(id);
	}

	@Override
	public List<Storage> queryStorageExample(StorageExample storageExample) {
		return storageMapper.selectByExample(storageExample);
	}

}
