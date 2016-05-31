package com.adhyan.contactmgr.service;

import com.adhyan.contactmgr.model.ContactDTO;

import java.util.List;

/**
 * Created by adhyan on 5/30/16.
 */
public interface ContactService {
    int createContact();
    void editContact();
    List<ContactDTO> fetchAllContacts();
}
