package com.adhyan.contactmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        ContactDTO contactDTO = new ContactDTO.ContactBuilder("Adhyan", "Srivastava")
//                .withEmail("ad@gmail.com")
//                .withPhone(8899006677L)
//                .build();
//        int id = save(contactDTO);
//
//        // Display a list of contacts before the update
//        System.out.println("%n%nBefore the update %n%n");
//        for (ContactDTO c: fetchAllContacts()) {
//            System.out.println(c);
//        }
//
//        //Get the persisted contactDTO
//        ContactDTO c = findContactById(id);
//
//        //update the contactDTO
//        c.setFirstName("Ados");
//
//        //Persist the changes
//        System.out.println("%n%nUpdating...%n%n");
//        update(c);
//        System.out.println("%n%nUpdate complete%n%n");
//
//
//        //Display List of contacts after the update
//        System.out.println("%n%nAfter update %n%n");
//        for (ContactDTO c1: fetchAllContacts()) {
//            System.out.println(c1);
//        }
        SpringApplication.run(Application.class, args);

    }
}
