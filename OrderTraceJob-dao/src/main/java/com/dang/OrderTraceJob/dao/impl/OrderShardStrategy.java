package com.dang.OrderTraceJob.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dang.rocket.dao.ShardStrategy;

@Component(value = "shardStrategy")
public class OrderShardStrategy implements ShardStrategy {
	@Override
	public String getTargetDs(Long partition) {
		long mode = partition % 2;
		if (mode == 0) {
			return "order0Ds_R";
		}
		return "order1Ds_R";
	}

	@Override
	public List<String> getAllDs() {
		return Arrays.asList("order0Ds_R","order1Ds_R");
	}
}
