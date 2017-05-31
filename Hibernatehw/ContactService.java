package kpfu.itis.service;

import kpfu.itis.domain.ContactsEntity;

import java.util.List;

public interface ContactService {

    void deleteContact(Integer id);

    void saveOrUpdateContact(ContactsEntity contactsEntity);

    List<ContactsEntity> getAllContacts();

    ContactsEntity getContactById(int id);

}
