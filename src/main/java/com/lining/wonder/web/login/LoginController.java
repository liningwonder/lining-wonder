/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.web.login;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lining.wonder.common.Result;
import com.lining.wonder.common.ResultCodeEnum;
import com.lining.wonder.dto.LoginDTO;
import com.lining.wonder.vo.TokenVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/demo")
public class LoginController {
	
	@GetMapping("/hello")
	public Result<Long> hello() {
		return Result.build(ResultCodeEnum.SC_OK, 23754851322302474L);
	}
	
	@PostMapping("/login")
	public Result<TokenVO> login(@RequestBody LoginDTO loginDTO) {
		long start = System.currentTimeMillis();
		//TODO查询数据库，判断用户状态，获取用户ID 不增加记住我功能
		StpUtil.login(10001, false);
		SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
		TokenVO tokenVO = new TokenVO();
		BeanUtils.copyProperties(tokenInfo, tokenVO);
		log.debug("cost time is " + (System.currentTimeMillis() - start));
		return Result.build(ResultCodeEnum.SC_OK, tokenVO);
	}
	
}
