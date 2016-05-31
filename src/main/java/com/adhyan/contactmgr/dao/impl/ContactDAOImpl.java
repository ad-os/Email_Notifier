package com.adhyan.contactmgr.dao.impl;

import com.adhyan.contactmgr.dao.ContactDAO;
import com.adhyan.contactmgr.model.ContactDTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO {
    //Hold a reusable reference to a sessionFactory (since we need only one)
    private final SessionFactory sessionFactory = buildSessionFactory();

    public SessionFactory buildSessionFactory() {
        //create a StandardSeriveRegistry
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public List<ContactDTO> fetchAllContacts() {
        //open a session
        Session session = sessionFactory.openSession();

        //Create Criteria
        Criteria criteria = session.createCriteria(ContactDTO.class);

        //Get a list of contact objects according to the Criteria object
        List<ContactDTO> contactDTOs = criteria.list();

        //close the session
        session.close();
        return contactDTOs;
    }

    public ContactDTO findContactById(int id) {
        //open a session
        Session session = sessionFactory.openSession();

        // Retrieve the persistent object (or null if not found)
        ContactDTO contactDTO = session.get(ContactDTO.class, id);

        // close the session
        session.close();

        // Return the object
        return contactDTO;
    }

    public void update(ContactDTO contactDTO) {
        // open a session
        Session session = sessionFactory.openSession();

        // begin a transaction
        session.beginTransaction();

        //use the session to update the contactDTO
        session.update(contactDTO);

        //commit the transaction
        session.getTransaction().commit();

        //close the session
        session.close();
    }

    public int save(ContactDTO contactDTO) {
        //open a session
        Session session = sessionFactory.openSession();

        //Begin a transaction
        session.beginTransaction();

        //Use the session to save the contactDTO
        int id = Integer.parseInt(session.save(contactDTO) +"");

        //commit the transaction
        session.getTransaction().commit();


        //close the session
        session.close();
        return id;
    }
}
