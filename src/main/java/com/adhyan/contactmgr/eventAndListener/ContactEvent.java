package com.adhyan.contactmgr.eventAndListener;

import com.adhyan.contactmgr.model.ContactDTO;
import org.springframework.context.ApplicationEvent;

/**
 * Created by adhyan on 5/31/16.
 */
public class ContactEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private String eventType;
    private ContactDTO contactDTO;
    public ContactEvent(Object source, String eventType, ContactDTO contactDTO) {
        super(source);
        this.eventType = eventType;
        this.contactDTO = contactDTO;
    }

    public String getEventType() {
        return eventType;
    }

    public ContactDTO getContactDTO() {
        return contactDTO;
    }
}
