package com.dang.OrderTraceJob.dao.impl;

import java.util.List;
import java.util.Map;

import com.dang.OrderTraceJob.dao.WMSOrderTraceDao;
import com.dang.OrderTraceJob.dto.WMSOrderTrace;
import com.dang.rocket.core.annotation.Dao;
import com.dang.rocket.dao.mybatis.impl.MyBatisBaseDaoImpl;
import com.google.common.collect.Maps;
@Dao
public class WMSOrderTraceDaoImpl extends MyBatisBaseDaoImpl<WMSOrderTrace,java.lang.Long>  implements WMSOrderTraceDao {
	public List<WMSOrderTrace> getOrderTrace(int taskItemNum, String taskItemId){
		Map<String,Object> parameterMap=Maps.newHashMap();
		parameterMap.put("taskItemNum", taskItemNum);
		parameterMap.put("taskItemId", taskItemId);
		return getCurSqlSessionTemplate().selectList("com.dang.OrderTraceJob.dto.WMSOrderTrace.getByTbschedule", parameterMap);
	}

	@Override
	public void updateExtractFlag(String id) {
		getCurSqlSessionTemplate().update("com.dang.OrderTraceJob.dto.WMSOrderTrace.updateExtractFlag", id);
	}
}
