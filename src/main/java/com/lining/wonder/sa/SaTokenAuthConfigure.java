/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.sa;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenAuthConfigure implements WebMvcConfigurer {
	// 注册 Sa-Token 的拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册路由拦截器，自定义认证规则
		registry.addInterceptor(new SaInterceptor(handler -> {
			// 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
			SaRouter.match("/**", "/demo/**", r -> StpUtil.checkLogin());
			// 角色校验 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
			SaRouter.match("/admin/**", r -> StpUtil.checkRoleOr("admin", "super-admin"));
			// 权限校验 -- 不同模块校验不同权限  user 表示用户管理相关功能，可以继续再细分
			SaRouter.match("/user/**", r -> StpUtil.checkPermission("user:admin"));
			SaRouter.match("/bpm/**", r -> StpUtil.checkPermission("bpm:admin"));
			
		})).addPathPatterns("/**");
	}
}



