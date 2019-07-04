package com.drools.ch6;

import org.drools.compiler.kie.builder.impl.ClasspathKieProject;
import org.drools.compiler.kie.builder.impl.KieContainerImpl;
import org.drools.compiler.kie.builder.impl.KieServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author AdrainHuang
 * @Date 2019/7/1 21:42
 **/
public class KieContainerTest {
	
	@Test
	public void getKieContainer(){
		KieServices kieServices = KieServices.Factory.get();
		
		KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
		System.out.println(kieClasspathContainer);
		
		KieContainer kieContainer = kieServices.newKieClasspathContainer();
		System.out.println(kieContainer);
		
		KieContainer kieContainer1 = kieServices.newKieClasspathContainer("adrain-1");
		System.out.println(kieContainer1);
	}
	
	@Test
	public void getKieProject(){
		KieServicesImpl kieServices = (KieServicesImpl) KieServices.Factory.get();
		kieServices.registerListener(event -> {
			System.out.println("注册了listener");
		});
		KieContainerImpl kieContainer = (KieContainerImpl) kieServices.newKieClasspathContainer("ad-1");
		ClasspathKieProject kieProject = (ClasspathKieProject) kieContainer.getKieProject();
		System.out.println(kieProject);
		System.out.println(kieProject.getKieBaseNames());
		
		KieRepository repository = kieServices.getRepository();
		System.out.println(repository.getDefaultReleaseId());
		
		KieModule module = kieContainer.getKieModuleForKBase("costprice");
		System.out.println(module);
	}
	
	@Test
	public void getKb(){
		KieServicesImpl kieServices = (KieServicesImpl) KieServices.Factory.get();
		KieContainer kieContainer = kieServices.newKieClasspathContainer("ad-2");
		KieBase kieBase = kieContainer.getKieBase();
		KieBase kieBase1 = kieContainer.getKieBase("costprice");
		Assert.assertEquals(kieBase,kieBase1);
		
		//会创建kieBase
		KieSession costprice = kieContainer.newKieSession("costPrice");
		System.out.println(costprice);
	}
}
