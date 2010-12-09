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

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * Initialize a JNDI resource to access it outside a J2EE container without
 * modifying the configuration
 */
public class JndiInitializer {

	/**
	 * static loger
	 */
	public final static Log log = LogFactory.getLog(JndiInitializer.class);

	/**
	 * Spring Object that bind values
	 */
	private static SimpleNamingContextBuilder builder;

	/**
	 * JNDI name
	 */
	private String jndiName;

	/**
	 * Target object
	 */
	private Object target;

	/**
	 * Bind target into the JNDI (via spring naming context) tree
	 * 
	 * @throws NamingException
	 */
	public void init() throws NamingException {
		if (builder == null) {
			builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		}
		builder.bind(jndiName, target);
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}