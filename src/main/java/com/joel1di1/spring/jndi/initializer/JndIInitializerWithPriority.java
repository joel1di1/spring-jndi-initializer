package com.joel1di1.spring.jndi.initializer;

import javax.naming.NamingException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;

public class JndIInitializerWithPriority extends JndiInitializer implements BeanFactoryPostProcessor, PriorityOrdered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		try {
			init();
		} catch (NamingException e) {
			throw new BeanInitializationException("Impossible to bind jndi variable", e);
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
