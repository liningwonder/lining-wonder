/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.web.user;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.lining.wonder.common.Result;
import com.lining.wonder.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@SaCheckPermission("user:permissionList")
	@GetMapping("/permissionList")
	public Result<List<String>> permissionList() {
		List<String> list = StpUtil.getPermissionList();
		return Result.build(ResultCodeEnum.SC_OK, list);
	}
}
