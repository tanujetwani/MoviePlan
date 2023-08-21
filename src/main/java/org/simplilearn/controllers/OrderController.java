package org.simplilearn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.OrderDetails;
import org.simplilearn.entities.Orders;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.Movie2Repository;

import org.simplilearn.repositories.OrderDetailsRepo;
import org.simplilearn.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
	
	         
	         OrderRepository orderRepo;
	         OrderDetailsRepo ordDetRepo;
	         Movie2Repository movie2Repo;
	         CartRepository cartRepo;
	         
	         @Autowired
	         public OrderController(OrderRepository orderRepo, OrderDetailsRepo ordDetRepo, Movie2Repository movie2Repo, CartRepository cartRepo) {
	        	 
	        	 this.orderRepo=orderRepo;
	        	 this.ordDetRepo=ordDetRepo;
	        	 this.movie2Repo=movie2Repo;
	        	 this.cartRepo=cartRepo;
	         }
	         
	         @GetMapping("/submitcardDetails")
	         public String submitcardDet() {
	        	 
	        	 return "paymentGateway";
	         }
	         
	         
	         
	         
	         
	         
	         
	         @PostMapping("/paytheamount")
	         public String payAmount(HttpSession session,Model model,HttpServletRequest req) {
	              
	        	 //Check the card details if ok,then proceed for payment and order generation
	        	 
	        	 String first=req.getParameter("first");
	        	 String second=req.getParameter("second");
	        	 String third=req.getParameter("third");
	        	 String fourth=req.getParameter("fourth");
	        	// String validthrumonth=req.getParameter("validmonth");
	        	 //String validthruyear=req.getParameter("validyear");
	        	 String cvv=req.getParameter("cvv");
	        	 if(first.equals(" ")||second.equals(" ")|| third.equals(" ")|| fourth.equals(" "))
	        	 {
	        		 model.addAttribute("msg","Enter a valid card number");
	        		 return "paymentGateway";
	        	 }
	        	 else if(first.length()!=4 || second.length()!=4 || third.length()!=4 || fourth.length()!=4 ) {
	        		 
	        		 model.addAttribute("msg","The card number should be 12 digits long");
	        		 return "paymentGateway";
	        	 }
	        	 else if(cvv.equals(" ")|| cvv.length()!=3) {
	        		 
	        		 model.addAttribute("msg","Enter a valid cvv");
	        		 return "paymentGateway";
	        		 
	        		 
	        	 }
	        	 else {
	        	 
	        	 Users user=(Users)session.getAttribute("cuser");
	        	Orders order=new Orders();
	        	order.setUser(user);
	        	orderRepo.save(order);
	        	 float total_amt=0;
	        	 
	        	 List<Cart> carts=cartRepo.findByUserid(user.getUid());
	        	
	        	 //session.setAttribute("listofcarts2",carts);
	        	 
	        	 for(Cart c : carts) {
	        		 
	        		 OrderDetails ord_detail=new OrderDetails();
	        		 ord_detail.setMovie(c.getMovie());
	        		 ord_detail.setNoOfTickets(c.getNooftickets());
	        		 float amount=c.getNooftickets()*c.getMovie().getTicketprice();
	        		 ord_detail.setAmount(amount);
	        		 ord_detail.setOrder(order);
	        		 ordDetRepo.save(ord_detail);
	        		 order.addOrdDet(ord_detail);
	        		 total_amt+=amount;
	        	 }
	        	 
	        	 order.setTotal_amount(total_amt);
	        	 
	        	 orderRepo.save(order);
                  cartRepo.deleteByUserid(user.getUid());	        	
	        	 model.addAttribute("order",order);
	        	return "orderSummary"; 
	         
	        	 
	         }//End of else for card details verification 	 
      
	   
	         } //End of method   payAmount() 	 

	         
}    //End of Controller
