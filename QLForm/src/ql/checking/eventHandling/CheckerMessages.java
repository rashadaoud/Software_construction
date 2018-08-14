package ql.checking.eventHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import ql.utils.MessageTypeEnum;

public class CheckerMessages {

	private Map<MessageTypeEnum, List<EventMessage>> messages = new HashMap<>();
	
	public CheckerMessages() {
		
	}

	public Map<MessageTypeEnum, List<EventMessage>> getMessages() {
		return messages;
	}
	
	public List<EventMessage> getMessagesOfType(MessageTypeEnum type) {
		return messages.get(type);
	}

	public void setMessages(Map<MessageTypeEnum, List<EventMessage>> messages) {
		this.messages = messages;
	}
	
	public void insert(EventMessage message){
	    List<EventMessage> msgs = messages.get(message.getType());
		if(msgs == null){
			msgs = new ArrayList<>();
		    messages.put(message.getType(), msgs);
		}
		msgs.add(message);
	}
}
