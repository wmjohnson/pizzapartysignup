/**
 * 
 */
package org.pizzaparty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wjohnson
 *
 */
@Controller
public class AdminController {
	
	@GetMapping("/admin")
	  public String getSuccess() {
	    return "admin";
	  }

}
