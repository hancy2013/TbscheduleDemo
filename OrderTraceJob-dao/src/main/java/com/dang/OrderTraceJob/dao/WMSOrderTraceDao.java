package com.dang.OrderTraceJob.dao;

import java.util.List;

import com.dang.OrderTraceJob.dto.WMSOrderTrace;
import com.dang.rocket.dao.mybatis.MyBatisBaseDao;

public interface WMSOrderTraceDao extends MyBatisBaseDao<WMSOrderTrace, java.lang.Long>  {
	List<WMSOrderTrace> getOrderTrace(int taskItemNum, String taskItemId);
	
	void updateExtractFlag(String id); 
}
