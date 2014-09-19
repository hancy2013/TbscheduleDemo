package com.dang.OrderTraceJob.shell.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dang.OrderTraceAPI.api.OrderTraceService;
import com.dang.OrderTraceAPI.dto.OrderTrace;
import com.dang.OrderTraceJob.dto.WMSOrderTrace;
import com.dang.OrderTraceJob.service.WMSOrderTraceService;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
/**
 * 
 * @Title TbOrderTraceTask.java
 * @Package com.dang.OrderTraceJob.shell.task
 * @Description WMS系统订单详情页处理信息TbSchedule版
 * @author tutu
 * @date 2014-9-17
 */
public class TbOrderTraceTask  implements IScheduleTaskDealSingle<WMSOrderTrace> {
	private static transient Logger DLOG = LoggerFactory.getLogger(TbOrderTraceTask.class);
	private static OrderTrace orderTrace = new OrderTrace();
	@Resource
	private WMSOrderTraceService wmsOrderTraceService;
	
	@Resource
	private OrderTraceService orderTraceService;
	
	@Override
	public List<WMSOrderTrace> selectTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> taskItemList,
			int eachFetchDataNum) throws Exception {
		List<WMSOrderTrace> orderTraces=new ArrayList<WMSOrderTrace>();
		for(TaskItemDefine taskItem:taskItemList){
			orderTraces.addAll(wmsOrderTraceService.getOrderTrace(taskItemNum, taskItem.getTaskItemId()));
		}
		DLOG.info("current machine total task entities:"+orderTraces.size());
		return orderTraces;
	}

	@Override
	public Comparator<WMSOrderTrace> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(WMSOrderTrace task, String ownSign) throws Exception {
		BeanUtils.copyProperties(orderTrace , task);
		try{
			// ordertraceapi dubbo 保存WMSOrderTrace
			orderTraceService.saveOrderTrace(orderTrace);
			// 更新WMSOrderTrace状态
			wmsOrderTraceService.updateExtractFlag(task);
		}catch(Exception e){
			DLOG.error("保存订单处理信息失败:",e);
			return false;
		}
		return true;
	}
	
}
