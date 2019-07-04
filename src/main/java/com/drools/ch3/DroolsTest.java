package com.drools.ch3;

import org.drools.compiler.kie.builder.impl.KieServicesImpl;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author AdrainHuang
 * @Date 2019/6/15 17:43
 **/
public class DroolsTest {
	
	@Test
	public void costPrice(){
		KieServices kieServices = KieServices.Factory.get();
		KieContainer container = kieServices.getKieClasspathContainer();
		//
		KieSession kieSession = container.newKieSession("costPrice");
		
		Person person = new Person("Adrain", 70);
		Car car = new Car("宝马", 10000D);
		car.setPerson(person);
		kieSession.insert(car);
		
		int count = kieSession.fireAllRules();
		System.out.println("触发的数量"+count);
		kieSession.dispose();
	}
	
	/**
	 * 注册监听 器
	 */
	@Test
	public void setListener(){
		KieServicesImpl kieServices = (KieServicesImpl) KieServices.Factory.get();
		kieServices.registerListener(event->{
			System.out.println("----_#####"+event.getKieModuleUrl());
		});
		KieContainer kieContainer = kieServices.newKieClasspathContainer("first-a");
		System.out.println(kieContainer);
	}
}
