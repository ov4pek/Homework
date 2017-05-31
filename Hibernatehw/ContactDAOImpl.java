package kpfu.itis.dao;

import kpfu.itis.domain.ContactsEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void deleteContact(Integer id) {
        ContactsEntity contact = sessionFactory.getCurrentSession().load(
                ContactsEntity.class, id);
        sessionFactory.getCurrentSession().delete(contact);
    }

    public void saveOrUpdateContact(ContactsEntity contactsEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(contactsEntity);
    }

    public List<ContactsEntity> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("from ContactsEntity ")
                .list();
    }

    public ContactsEntity getContactById(int id) {
        ContactsEntity contactsEntity = null;
        try {
            Criteria crit = sessionFactory.openSession().createCriteria(ContactsEntity.class);
            crit.add(Restrictions.idEq(id));
            contactsEntity = (ContactsEntity) crit.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactsEntity;
    }
}