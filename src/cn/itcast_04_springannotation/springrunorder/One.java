package cn.itcast_04_springannotation.springrunorder;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class One implements ApplicationContextAware ,InitializingBean {
	public One(String one) {
		System.out.println(one);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0){
		System.out.println("setApplicationContext");
	}
	
	@Override
	public void afterPropertiesSet() {
		System.out.println("afterPropertiesSet");
	}
	

}
