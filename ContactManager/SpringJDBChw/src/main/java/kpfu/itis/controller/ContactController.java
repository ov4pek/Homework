package kpfu.itis.controller;

import kpfu.itis.dao.ContactDAO;
import kpfu.itis.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Contact> listContact = contactDAO.getAllContacts();
        model.addObject("listContact", listContact);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("addContact");
        return model;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute Contact contact) {
        contactDAO.addContact(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public ModelAndView editContact(@ModelAttribute Contact contact) {
        contactDAO.editContact(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        contactDAO.deleteContact(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(id);
        ModelAndView model = new ModelAndView("updateContact");
        model.addObject("contact", contact);
        return model;
    }
}