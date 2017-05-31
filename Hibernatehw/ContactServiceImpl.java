package kpfu.itis.service;

import kpfu.itis.dao.ContactDAO;
import kpfu.itis.domain.ContactsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public void deleteContact(Integer id) {
        contactDAO.deleteContact(id);
    }

    @Transactional
    public void saveOrUpdateContact(ContactsEntity contactsEntity) {
        contactDAO.saveOrUpdateContact(contactsEntity);
    }

    @Transactional
    public List<ContactsEntity> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Transactional
    public ContactsEntity getContactById(int id) {
        return contactDAO.getContactById(id);
    }
}
