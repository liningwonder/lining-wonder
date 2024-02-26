/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/18
 * @Description TODO
 */

package com.lining.wonder.mybatis;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.tenant.TenantFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MybatisConfig {
	
	public MybatisConfig() {
		//开启审计功能
		AuditManager.setAuditEnable(true);
		//设置 SQL 审计收集器
/*		MessageCollector collector = new ConsoleMessageCollector();
		AuditManager.setMessageCollector(collector);*/
		AuditManager.setMessageCollector(auditMessage ->
				log.info("{},{}ms", auditMessage.getFullSql()
						, auditMessage.getElapsedTime())
		);
	}
	
	@Bean
	public TenantFactory tenantFactory(){
		TenantFactory tenantFactory = new WonderTenantFactory();
		return tenantFactory;
	}
}
