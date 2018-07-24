/**
 * 
 */
package com.tina.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tina.dao.UserinfoMapper;
import com.tina.entity.Userinfo;

import junit.framework.TestCase;

/**
 * @author 何悟隆
 *
 */
public class TestMybatis extends TestCase {

	private String resourcePath = "spring_springmvc_mybatis/spring_mybatis.xml";
	private SqlSessionFactory sessionFactory;
	private Reader reader;
	private List<Userinfo> userinfos;

	/**
	 * 
	 */
	public TestMybatis() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public TestMybatis(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		reader = Resources.getResourceAsReader(resourcePath);
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testQuery() {
		SqlSession session = sessionFactory.openSession();
		userinfos = session.getMapper(UserinfoMapper.class).selectByExample(null);
		for (Userinfo userinfo : userinfos) {
			System.out.println(userinfo);
		}
	}

}
