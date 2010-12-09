package com.joel1di1.spring.jndi.initializer;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyPlaceholderConfigurerFake extends PropertyPlaceholderConfigurer {
	@Override
	protected void loadProperties(Properties props) throws IOException {
		Witness.sendMessage("placeholder loadProperties");
		super.loadProperties(props);
	}
}
