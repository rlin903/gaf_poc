package com.gaf.integration.controller;

import com.gaf.integration.exception.ResourceNotFoundException;
import com.gaf.integration.model.Contact;
import com.gaf.integration.service.CRUDService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping({"/contacts"})
@Api(value="Contact Management System",
        description="Operations pertaining to contact in ERP System")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    CRUDService dataService;

    @GetMapping
    public List<Contact> findAll(){
        logger.debug("let's find all contacts");
        return dataService.findAllContact();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id) throws ResourceNotFoundException {
        logger.debug("let's find contact, id={}", id);
        return dataService.findContactById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + id));
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact){
        logger.debug("let's create a contact, name={}", contact.getName());
        return dataService.createContact(contact);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Contact> update(@PathVariable("id") long id,
                                          @RequestBody Contact contact)  throws ResourceNotFoundException {
        logger.debug("let's update contact, id={}", id);
        return dataService.findContactById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = dataService.updateContact(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
