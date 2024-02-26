/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.web.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lining.wonder.common.Result;
import com.lining.wonder.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@SaCheckPermission("admin:hello")
	@GetMapping("/hello")
	public Result<Long> hello() {
		return Result.build(ResultCodeEnum.SC_OK, 23754851322302474L);
	}
}
