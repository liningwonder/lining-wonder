/*
 * Copyright (c) 2023 the UnionPay. All rights reserved.
 * @author Ning Li
 * @Date 2023/11/7
 * @Description Base Entity
 */

package com.lining.wonder.domain;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;

import java.util.Date;

/**
 * @author liningwonder
 */
public class BaseEntity {
    
    /**
     * 乐观锁
     */
    @Column(version = true)
    public Integer version;
    /**
     * 多租户
     */
    @Column(tenantId = true)
    public String tenantId;
    /**
     * 基于查询的CDC
     */
    @Column(onInsertValue = "now()")
    public Date createTime;
    /**
     * 基于查询的CDC
     */
    @Column(onUpdateValue = "now()", onInsertValue = "now()")
    public Date updateTime;
    /**
     * 逻辑删除 主键必须与业务无关，对于有业务唯一性约束的表，需根据业务需要，进行业务逻辑修改（要么业务不提供删除功能，要么需要物理删除）
     */
    public Boolean isDelete;
    
    /**
     * 创建人
     */
    public String creator;
    
    /**
     * 操作人
     */
    public String operator;
}
