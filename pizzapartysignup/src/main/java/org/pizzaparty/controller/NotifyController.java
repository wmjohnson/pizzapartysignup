/**
 * 
 */
package org.pizzaparty.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.pizzaparty.service.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author wjohnson
 *
 */
@Controller
public class NotifyController {
	  private static final Logger logger = LoggerFactory.getLogger(NotifyController.class);
	
	  @Autowired 
	  private NotifyService notifyService;

	  @PostMapping("/notifyAll")
	  public String greetingSubmit() {
	    
		  CompletableFuture<String> resp = notifyService.notifyAllContacts();
//		  try {
//			logger.info("Controller response =" + resp.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  
		  return "notifyStatus";
	  }
	  
}
