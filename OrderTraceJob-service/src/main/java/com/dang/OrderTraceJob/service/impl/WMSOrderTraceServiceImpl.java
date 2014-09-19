package com.dang.OrderTraceJob.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dang.OrderTraceJob.dao.WMSOrderTraceDao;
import com.dang.OrderTraceJob.dto.WMSOrderTrace;
import com.dang.OrderTraceJob.service.WMSOrderTraceService;
@Service(value="wmsOrderTraceService")
public class WMSOrderTraceServiceImpl implements WMSOrderTraceService{
	@Resource
	private WMSOrderTraceDao wMSOrderTraceDao;

	@Override
	public List<WMSOrderTrace> getOrderTrace(int taskItemNum, String taskItemId) {
		return wMSOrderTraceDao.getOrderTrace(taskItemNum, taskItemId);
	}

	@Override
	public void updateExtractFlag(WMSOrderTrace orderTrace) {
		wMSOrderTraceDao.updateExtractFlag(orderTrace.getId());
	}

}
