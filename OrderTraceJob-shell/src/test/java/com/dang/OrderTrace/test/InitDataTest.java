/**
 * @Title InitDataTest.java
 * @Package com.dang.OrderTrace.test
 * @Description TODO
 * @author tutu
 * @date 2014-9-18
 */
package com.dang.OrderTrace.test;

import java.util.Date;

import org.junit.Test;

import com.dang.OrderTraceJob.dao.impl.WMSOrderTraceDaoImpl;
import com.dang.OrderTraceJob.dto.WMSOrderTrace;

/**
 * @Title InitDataTest.java
 * @Package com.dang.OrderTrace.test
 * @Description TODO
 * @author tutu
 * @date 2014-9-18
 */
public class InitDataTest extends BaseServiceTests {
	@Test
	public void init(){
		WMSOrderTraceDaoImpl wMSOrderTraceDao = context.getBean(WMSOrderTraceDaoImpl.class);
		WMSOrderTrace wmsOrderTrace=new WMSOrderTrace();
		for(int i=0;i<10000;i++){
			wmsOrderTrace.setId(String.valueOf(i));
			wmsOrderTrace.setOid(String.valueOf(i));
			wmsOrderTrace.setEvent_name("订单导入");
			wmsOrderTrace.setEvent_time(new Date());
			wmsOrderTrace.setEvent_info("您的订单已经进入当当北京仓库，准备出库");
			wmsOrderTrace.setEvent_location("北京仓库");
			wmsOrderTrace.setExtract_flag("0");
			wMSOrderTraceDao.save(wmsOrderTrace);
		}
	}
}
