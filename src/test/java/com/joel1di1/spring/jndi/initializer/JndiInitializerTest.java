package com.joel1di1.spring.jndi.initializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

public class JndiInitializerTest {

	JndiInitializer jndiInitialiser;

	@Before
	public void setUp() throws Exception {
		jndiInitialiser = new JndiInitializer();
	}

	@Test
	public void testInit_WithSourceAndTarget_ShouldBindJndi() throws NamingException {
		// Setup
		jndiInitialiser.setJndiName("java:comp/env/test");
		jndiInitialiser.setTarget("I'm something in JNDI");

		// Action
		jndiInitialiser.init();

		// Assert
		assertEqualsInJndi("I'm something in JNDI", "java:comp/env/test");
	}

	public static void assertEqualsInJndi(Object expected, String jndiName) {
		Context context;
		try {
			context = new InitialContext();
			Object jndiVar = context.lookup(jndiName);
			assertEquals(expected, jndiVar);
		} catch (NamingException e) {
			e.printStackTrace();
			fail();
		}

	}

}
