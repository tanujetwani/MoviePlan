package org.simplilearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	     @GetMapping("/")
	     public String showHome() {
	    	 
	    	 return "home";
	     }
	     
	     
	     @GetMapping("/register")
	     public String showRegister() {
	    	 
	    	 return "register";
	     }

	     
	     @GetMapping("/login")
	     public String showLogin() {
	    	 
	    	 return "login";
	     }

         @GetMapping("/logout")
         public String logout() {
        	 return "home";
        	 
         }


}
