package com.dang.OrderTraceJob.shell.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

/** 
 * @date 2014-3-28 下午1:55:02 
 *  
 */
public class DangSpringContainer{

	private static final Logger logger = LoggerFactory.getLogger(DangSpringContainer.class);

    private static FileSystemXmlApplicationContext context;
    
    public static FileSystemXmlApplicationContext getContext() {
    	init();
		return context;
	}

    public static void init() {
    	if(context != null){
    		return;
    	}
    	
    	initSpringContext();
	}

	public static void stop() {
		try {
            if (context != null) {
                context.stop();
                context.close();
                context = null;
            }
        } 
		catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
	}
	
	/**
	 * 获取spring会话
	 * 
	 * @return
	 */
	public synchronized static void initSpringContext() {
		if(context == null){
			Log4jConfigurer.setWorkingDirSystemProperty("log4j.WebApp.root");
			String path = PathUtil.getAppConfPath()
					.concat(PathUtil.getSeparator()).concat("spring.xml");
			path = PathUtil.getPath(path);
			context =  new FileSystemXmlApplicationContext(path);
		}
	}
}
