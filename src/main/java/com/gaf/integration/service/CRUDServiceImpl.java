package com.gaf.integration.service;

import com.gaf.integration.model.Contact;
import com.gaf.integration.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAllContact(){
        return contactRepository.findAll();
    }

    public Optional<Contact>  findContactById(long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
