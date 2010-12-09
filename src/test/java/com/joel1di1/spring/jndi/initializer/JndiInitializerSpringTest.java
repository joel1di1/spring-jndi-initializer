package com.joel1di1.spring.jndi.initializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-jndi-context.xml", "classpath:spring-context.xml" })
public class JndiInitializerSpringTest {

	@Test
	public void jndiInitializer_WithSpringConfig_ShouldInitializeBean() {
		JndiInitializerTest.assertEqualsInJndi(new MyBean("Yeah"), "java:comp/env/bean/MyBean");
	}
}
