package com.adhyan.contactmgr.service.impl;


import com.adhyan.contactmgr.dao.impl.ContactDAOImpl;
import com.adhyan.contactmgr.eventAndListener.ContactEvent;
import com.adhyan.contactmgr.model.ContactDTO;
import com.adhyan.contactmgr.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService, ApplicationEventPublisherAware {

    @Autowired
    ContactDAOImpl contactDAO;

    private ApplicationEventPublisher publisher;
    //Builder pattern
    ContactDTO contactDTO = new ContactDTO.ContactBuilder("Adhyan", "Srivastava")
            .withEmail("adhyan2095@gmail.com")
            .withPhone(8899006677L)
            .build();

    public int createContact() {
        int id = contactDAO.save(contactDTO);
        publisher.publishEvent(new ContactEvent(this, "ADD", contactDTO));
        return id;
    }

    public void editContact() {
        contactDAO.update(contactDTO);
    }

    public List<ContactDTO> fetchAllContacts() {
        return contactDAO.fetchAllContacts();
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
