/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String captcha;
	
}
