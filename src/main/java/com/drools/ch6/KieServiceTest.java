package com.drools.ch6;

import org.junit.Test;
import org.kie.api.internal.utils.ServiceRegistry;

/**
 * @Author AdrainHuang
 * @Date 2019/7/1 21:38
 **/
public class KieServiceTest {
	
	@Test
	public void getCustomerKieService(){
		ShareCustomer shareCustomer = ServiceRegistry.getInstance().get(ShareCustomer.class);
		System.out.println(shareCustomer);
	}
}
