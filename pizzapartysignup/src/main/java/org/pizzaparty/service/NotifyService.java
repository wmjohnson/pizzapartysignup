/**
 * 
 */
package org.pizzaparty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.pizzaparty.model.ContactEntity;
import org.pizzaparty.model.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.notify.v1.service.Notification;

/**
 * @author wjohnson
 *
 */
@Service
public class NotifyService {
	private static final Logger logger = LoggerFactory.getLogger(NotifyService.class);

	@Value("${authToken}")
	private String TWILIO_AUTH_TOKEN;
	
	public static final String ACCOUNT_SID =
	         "ACf6bcdb1c28eb8a7492f5a937e522f487";

	public static final String SERVICE_SID = "IS8ce764b7c405fcb4765fedf62b3cb6f9";
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Async
	public CompletableFuture<String> notifyAllContacts() {
				
		Iterable<ContactEntity> contactIt = contactRepository.findAll();
		
		List<String> contactsListBindings = new ArrayList<String>();
		contactIt.forEach(contact -> contactsListBindings.add("{\"binding_type\":\"sms\",\"address\":\"" + contact.getPhone() + "\"}"));
		
		contactsListBindings.forEach(contact -> logger.info("Contact =" + contact.toString()));

		Twilio.init(ACCOUNT_SID, TWILIO_AUTH_TOKEN);
		Notification notification = Notification
			    .creator(SERVICE_SID)
			    .setBody("Your pizza will be delivered today. Enjoy!")
			    .setToBinding(contactsListBindings)
			    .create();
		
		logger.info("sms send done ==" + TWILIO_AUTH_TOKEN);
		return CompletableFuture.completedFuture(new String("complete"));
	}

}
