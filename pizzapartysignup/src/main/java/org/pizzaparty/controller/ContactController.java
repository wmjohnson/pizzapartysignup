/**
 * 
 */
package org.pizzaparty.controller;

import java.sql.Date;

import org.pizzaparty.model.Contact;
import org.pizzaparty.model.ContactEntity;
import org.pizzaparty.model.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wjohnson
 *
 */
@Controller
public class ContactController {
	
	  @Autowired
	  private ContactRepository contactRepository;

	  @GetMapping("/contact")
	  public String greetingForm(Model model) {
	    model.addAttribute("contact", new Contact());
	    return "contact";
	  }

	  @PostMapping("/contact")
	  public String greetingSubmit(@ModelAttribute Contact contact) {
	    
		  ContactEntity contactData = new ContactEntity();
		  contactData.setName(contact.getName());
		  contactData.setEmail(contact.getEmail());
		  contactData.setPhone(contact.getPhone());
		  contactRepository.save(contactData);
		  
		  return "result";
	  }

	}
