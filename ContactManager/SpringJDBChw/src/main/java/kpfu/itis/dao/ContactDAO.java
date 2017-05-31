package kpfu.itis.dao;

import kpfu.itis.model.Contact;

import java.util.List;

public interface ContactDAO {

    void addContact(Contact contact);

    void deleteContact(int id);

    void editContact(Contact contact);

    List<Contact> getAllContacts();

    Contact get(int id);
}
