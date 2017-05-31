package kpfu.itis.controller;

import kpfu.itis.domain.ContactsEntity;
import kpfu.itis.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/")
    public String listContacts(Map<String, Object> map) {
        map.put("contactList", contactService.getAllContacts());
        return "index";
    }

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        ContactsEntity contactsEntity = new ContactsEntity();
        model.addObject("contactsEntity", contactsEntity);
        model.setViewName("saveOrUpdate");
        return model;
    }

    @RequestMapping(value = "/editContact/{id}", method = RequestMethod.GET)
    public ModelAndView editContact(@PathVariable("id") int id) {
        ContactsEntity contactsEntity = contactService.getContactById(id);
        ModelAndView model = new ModelAndView("saveOrUpdate");
        model.addObject("contactsEntity", contactsEntity);
        return model;
    }

    @RequestMapping(value = "/saveOrUpdateContact", method = RequestMethod.POST)
    public String updateContact(ContactsEntity contactsEntity) {
        contactService.saveOrUpdateContact(contactsEntity);
        return "redirect:/";
    }

    @RequestMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable("id") int id) {
        contactService.deleteContact(id);
        return "redirect:/";
    }
}