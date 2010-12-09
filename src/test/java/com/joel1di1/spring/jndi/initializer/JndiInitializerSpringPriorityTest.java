/**
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
