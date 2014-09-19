package com.dang.OrderTraceJob.shell;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dang.OrderTraceJob.shell.container.DangSpringContainer;

/**
 * 启动方法
 * @author xinxinjs
 *
 */
public class Program {
	public static void main(String args[]){
		FileSystemXmlApplicationContext context = DangSpringContainer.getContext();
		context.start();		
	}
}
