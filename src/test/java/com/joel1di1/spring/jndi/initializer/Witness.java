package com.joel1di1.spring.jndi.initializer;

import java.util.ArrayList;
import java.util.List;

public class Witness {

	static List<String> messages = new ArrayList<String>();

	public static void sendMessage(String msg) {
		messages.add(msg);
	}

	public static void clear() {
		messages.clear();
	}

}
