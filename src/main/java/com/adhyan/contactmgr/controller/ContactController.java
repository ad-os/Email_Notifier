package com.adhyan.contactmgr.controller;

import com.adhyan.contactmgr.model.ContactDTO;
import com.adhyan.contactmgr.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    ContactServiceImpl contactService;

    @RequestMapping("/insert")
    public String insert() {
        contactService.createContact();
        showAllContacts();
        return "Successfully inserted :)";
    }

    @RequestMapping("/update")
    public String update() {
        contactService.editContact();
        showAllContacts();
        return "Successfully updated";
    }

    public void showAllContacts() {
        for (ContactDTO c: contactService.fetchAllContacts()) {
            System.out.println(c);
        }
    }
}
