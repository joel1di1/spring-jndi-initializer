package com.joel1di1.spring.jndi.initializer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JndiInitializerSpringPriorityTest {
	@Before
	public void setup() {
		Witness.clear();
	}

	@Test
	public void jndiInitializer_WithSpringConfig_ShouldInitializeJndiBeforePlaceHolder() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-context-jndi-first.xml");
		MyBean myBean = (MyBean) beanFactory.getBean("myBean");
		assertEquals("LOCAL", myBean.getName());

		assertEquals(2, Witness.messages.size());
		assertEquals("jndiInit with priority init", Witness.messages.get(0));
		assertEquals("placeholder loadProperties", Witness.messages.get(1));
	}

	@Test
	public void jndiInitializer_WithSpringConfig_ShouldInitializePlaceholderBeforePlaceHolder() {
		new ClassPathXmlApplicationContext("spring-context-placeholder-first.xml");

		assertEquals(2, Witness.messages.size());
		assertEquals("placeholder loadProperties", Witness.messages.get(0));
		assertEquals("jndiInit init", Witness.messages.get(1));

		JndiInitializerTest.assertEqualsInJndi("LOCAL", "java:comp/env/myName");
	}
}
