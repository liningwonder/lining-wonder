/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/23
 * @Description TODO
 */

package com.lining.wonder.domain;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("t_user")
public class User extends BaseEntity{
	
	@Id(keyType = KeyType.Auto)
	private Long id;
	
	private String name;
	
	private String phone;

	private String email;
}
