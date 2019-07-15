package com.gaf.integration.service;

import com.gaf.integration.model.Contact;

import java.util.List;
import java.util.Optional;

public interface CRUDService {
    public List<Contact> findAllContact();
    Optional<Contact> findContactById(long id);
    Contact createContact(Contact contact );
    Contact updateContact(Contact contact);
}
