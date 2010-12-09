package com.joel1di1.spring.jndi.initializer;

import javax.naming.NamingException;

public class JndiInitializerFake extends JndiInitializer {
	@Override
	public void init() throws NamingException {
		Witness.sendMessage("jndiInit init");
		super.init();
	}

}
