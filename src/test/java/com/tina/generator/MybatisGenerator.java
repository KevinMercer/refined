/**
 * 
 */
package com.tina.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author 何悟隆
 *
 */
public class MybatisGenerator {

	/**
	 * 
	 */
	public MybatisGenerator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * @注释日期 20170719
		 * @注释理由 表格已创建完成，重新创建需要删除相关xml文件
		 * @重启日期 20170721
		 * @重启理由 新建role_permission表格相关的文件
		 * @注释日期 20170721
		 * @注释理由 role_permission表格以创建完成，role_permission相关文件更名为rolepermission
		 * @重启日期 20170723
		 * @重启理由 新建empinfo与deptinfo表格相关文件
		 * @注释日期 20170723
		 * @注释理由 表格创建完成
		 */
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File("G:/skeyedu/MyEclipse2017WorkSpace/Refined/src/main/resources/mybatis_generator/generatorConfig.xml");
			ConfigurationParser parser = new ConfigurationParser(warnings);
			Configuration configuration = parser.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warnings);
			generator.generate(null);
			System.out.println("创建成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
