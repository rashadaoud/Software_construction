package ql.checking.eventHandling;

import ql.utils.MessageTypeEnum;

public class EventMessage {

	private String text;
	private MessageTypeEnum type;
	
	public EventMessage(String text, MessageTypeEnum type) {
		this.text = text;
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public MessageTypeEnum getType() {
		return type;
	}
	public void setType(MessageTypeEnum type) {
		this.type = type;
	}

}