package com.drools.ch8;

import com.drools.BaseTest;
import com.drools.ch3.Car;
import com.drools.ch3.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @Author AdrainHuang
 * @Date 2019/7/2 22:02
 **/
public class AppTest extends BaseTest {
	
	@Test
	public void testStatic(){
		KieSession kieSession = this.getKieSessionBySessionName("static-rule-kseesion");
		Person person = new Person("Adrain", 70);
		Car car = new Car("宝马", 10000D);
		car.setPerson(person);
		kieSession.insert(car);
		
		int count = kieSession.fireAllRules();
		System.out.println("触发的数量"+count);
		kieSession.dispose();
	}
	
	@Test
	public void testEnable(){
		KieSession kieSession = this.getKieSessionBySessionName("enable-rule-kseesion");
		int count = kieSession.fireAllRules();
		System.out.println("触发的数量"+count);
		kieSession.dispose();
	}
	
	@Test
	public void testGroup(){
		KieSession kieSession = this.getKieSessionBySessionName("group-rule-session");
		//获取焦点只会执行一次
		kieSession.getAgenda().getAgendaGroup("group1").setFocus();
		int count = kieSession.fireAllRules();
		System.out.println("触发的数量"+count);
		
		System.out.println("###########");
		kieSession.getAgenda().getAgendaGroup("group1").setFocus();
		int count1 = kieSession.fireAllRules();
//		//count1 = 0
		System.out.println("触发的数量"+count1);
//		System.out.println("###########");
//		kieSession.getAgenda().getActivationGroup("group5");
//		int count2 = kieSession.fireAllRules();
//		System.out.println("触发的数量"+count2);
		kieSession.dispose();
	}
}
