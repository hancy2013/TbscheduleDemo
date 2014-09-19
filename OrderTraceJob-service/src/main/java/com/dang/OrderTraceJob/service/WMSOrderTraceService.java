package com.dang.OrderTraceJob.service;

import java.util.List;

import com.dang.OrderTraceJob.dto.WMSOrderTrace;

public interface WMSOrderTraceService {
	List<WMSOrderTrace> getOrderTrace(int taskItemNum,String taskItemId);
	
	void updateExtractFlag(WMSOrderTrace orderTrace);
}
