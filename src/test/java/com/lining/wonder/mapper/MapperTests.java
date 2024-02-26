/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.mapper;

import com.lining.wonder.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTests {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test() {
		List<User> list = userMapper.selectAll();
		System.out.println(list.size());
	}
	
}
