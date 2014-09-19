package com.dang.OrderTraceJob.dto;

import com.dang.OrderTraceAPI.dto.OrderTrace;

@SuppressWarnings("serial")
public class WMSOrderTrace extends OrderTrace  {
	
	private String id;
	private String extract_flag;
	
	public WMSOrderTrace() {
		this.event_source="WMS";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExtract_flag() {
		return extract_flag;
	}

	public void setExtract_flag(String extract_flag) {
		this.extract_flag = extract_flag;
	}
	
}
