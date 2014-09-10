package net.kraklups.solarapp.model.parkservice;

import java.util.List;

import net.kraklups.solarapp.model.messageevent.MessageEvent;

public class MessageEventBlock {

    private List<MessageEvent> messageEvents;
    private boolean existMoreMessageEvents;
	
    public MessageEventBlock(List<MessageEvent> messageEvents, boolean existMoreMessageEvents) {
        
        this.messageEvents = messageEvents;
        this.existMoreMessageEvents = existMoreMessageEvents;

    }
    
    public List<MessageEvent> getMessageEvents() {
        return messageEvents;
    }
    
    public boolean getExistMoreMessageEvents() {
        return existMoreMessageEvents;
    }
}
