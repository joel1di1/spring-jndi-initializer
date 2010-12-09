package com.joel1di1.spring.jndi.initializer;

import javax.naming.NamingException;

public class JndiInitializerWithPriorityFake extends JndIInitializerWithPriority {
	@Override
	public void init() throws NamingException {
		Witness.sendMessage("jndiInit with priority init");
		super.init();
	}
}
