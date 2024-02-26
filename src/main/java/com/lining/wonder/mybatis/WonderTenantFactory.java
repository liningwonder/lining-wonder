/**
 * Copyright (c) 2024 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2024/2/18
 * @Description TODO
 */

package com.lining.wonder.mybatis;

import com.mybatisflex.core.tenant.TenantFactory;

public class WonderTenantFactory implements TenantFactory {
     @Override
     public Object[] getTenantIds() {
         Integer[] ids = new Integer[1];
         ids[0] = 0;
         return ids;
     }
}
