package com.dang.OrderTrace.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dang.OrderTraceJob.shell.container.PathUtil;
/**
 * service测试基类
 * @author gongxinyi
 *
 */
public class BaseServiceTests {
		public static ApplicationContext context;
		
		@Before
	    public void setUp() throws Exception {
	    	String path = PathUtil.getAppConfPath().concat(PathUtil.getSeparator()).concat("spring.xml");
			path = PathUtil.getPath(path);
	    	context = new FileSystemXmlApplicationContext(path);
	    }

	    @After
	    public void tearDown() throws Exception {
	    	context = null;
	    }
}
