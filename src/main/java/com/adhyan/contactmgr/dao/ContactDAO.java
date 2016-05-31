package com.adhyan.contactmgr.dao;

import com.adhyan.contactmgr.model.ContactDTO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by adhyan on 5/30/16.
 */
public interface ContactDAO {
    SessionFactory buildSessionFactory();
    List<ContactDTO> fetchAllContacts();
    ContactDTO findContactById(int id);
    void update(ContactDTO contactDTO);
    int save(ContactDTO contactDTO);
}
