package com.adhyan.contactmgr.eventAndListener;

import com.adhyan.contactmgr.service.MailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by adhyan on 5/31/16.
 */
@Component
public class EventListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    MailNotificationService notificationService;

    public void onApplicationEvent(ApplicationEvent event) {
        ContactEvent contactEvent = (ContactEvent) event;
        notificationService.sendNotification("adhyan2095@gmail.com", "Test", "Hi");
        System.out.println("Mail send to : " + contactEvent.getContactDTO());
    }
}
