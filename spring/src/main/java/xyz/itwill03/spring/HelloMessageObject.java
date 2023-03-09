package xyz.itwill03.spring;

import xyz.itwill02.factory.MessageObject;

public class HelloMessageObject implements MessageObject {
	@Override
	public String getMessage() {
		return "Hello";
	}
}