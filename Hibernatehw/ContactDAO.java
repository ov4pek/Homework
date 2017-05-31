package kpfu.itis.dao;

import kpfu.itis.domain.ContactsEntity;

import java.util.List;

public interface ContactDAO {

    void deleteContact(Integer id);

    void saveOrUpdateContact(ContactsEntity contactsEntity);

    List<ContactsEntity> getAllContacts();

    ContactsEntity getContactById(int id);
}
