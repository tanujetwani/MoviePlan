package org.simplilearn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Users;
import org.simplilearn.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	      
	        UsersRepository userRepo;
	        
	        @Autowired
	        public UserController(UsersRepository userRepo ) {
	        	this.userRepo=userRepo;
	        }
	
	     @PostMapping("/registerUser")
	     public String register(HttpServletRequest req, Model model) {
	    	 
	    	 String uname=req.getParameter("name");
	    	 String upwd=req.getParameter("pwd");
	    	 String email=req.getParameter("email");
	    	 String phone=req.getParameter("phone");
	    	 String userType=req.getParameter("userType");
	         
	    	 if(uname.equals("")) {
	    		 model.addAttribute("msg","Enter a valid username");
	    		 return "register";
	    	 }
	    	 else if(upwd.equals("")) {
	    		 model.addAttribute("msg", "Enter a password");
	    		 return "register";
	    	 }
	    	 else if(userRepo.findAllPwds().contains(upwd)) {
	    		 
	    		 model.addAttribute("msg","Use another password.This password is already in use");
	    		 for(String str: userRepo.findAllPwds()) {
	    			 System.out.println("Password:" +str);
	    		 }
	    	     return "register";
	    	 }
	    	 
	    	 Users user=new Users();
	    	 user.setUname(uname);
	    	 user.setUpwd(upwd);
	    	 user.setEmail(email);
	    	 user.setPhone(phone);
	    	 user.setUserType(userType);
	    	 
	    	 userRepo.save(user);
	    	 model.addAttribute("msg", "User "+"'"+ uname+"'"+ " registered successfully");
	    	 return "home";
	     }
	     
	     
	     @GetMapping("/loginUser")
	     public String login(HttpServletRequest req,Model model,HttpSession session) {
	    	 
	    	 String uname=req.getParameter("uname");
	    	 String passwd=req.getParameter("upwd");
	    	 
	    	 Users user=userRepo.findByUnameAndUpwd(uname,passwd);
	    	 
	    	 if(user!=null) {
	    	      
	    		 session.setAttribute("cuser",user);
	    		 
	    		 if(user.getUserType().equals("Customer")) {
	    			 model.addAttribute("listofmovies", null);
	    			 return "customerDashboard";
	    		 }
	    		 
	    		 else if(user.getUserType().equals("Admin")) {
	    			 
	    			 return "adminDashboard";
	    		 }
	    	 }
	    	 
	    	 
	    		 
	    		 model.addAttribute("msg1","Incorrect Username or Password");
	    		 return "login";
	    	
	    	 
	    	 
	     }

}
