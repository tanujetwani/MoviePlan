package org.simplilearn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;

import org.simplilearn.entities.Movie2;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.Movie2Repository;

import org.simplilearn.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
	
	
	          CartRepository cartRepo;
	          Movie2Repository movie2Repo;
	          MovieService movieService;
	          
	          @Autowired
	          public CartController(CartRepository cartRepo,Movie2Repository movie2Repo,MovieService movieService) {
	        	     
	        	  this.cartRepo=cartRepo;
	        	  this.movie2Repo=movie2Repo;
	        	  this.movieService=movieService;
	        	  
	          }
	          
	          
	          @PostMapping("/addtoCart")
	          public String addtocart(HttpServletRequest req,Model model,HttpSession session) {
	        	       
	        	  System.out.println("Entered AddTo cart");
	        	     int movieid=Integer.parseInt(req.getParameter("movieid"));
	        	     System.out.println("Movie id:"+ movieid);
	        	     Movie2 movie=movie2Repo.findById(movieid).get();
	        	     
	        	     Users user=(Users)session.getAttribute("cuser");
	        	     System.out.println("User id:"+ user.getUid());
	        	     
	        if(movie.getEnable()==true) { 
	        
	        	     int noOftickets=0;
	        	     Cart cart=new Cart();
	        	     Cart cart1=cartRepo.findByUseridAndMovieId(user.getUid(),movieid);
	        	
	        	  
	        	     if(cart1!=null) {
	        	         
	            	 
	        	        noOftickets=cart1.getNooftickets();
	        	        noOftickets++;
	        	        cart1.setNooftickets(noOftickets);
	        	        cartRepo.save(cart1);
	        	     }
	        	     else {
	        	    	 System.out.println("Entered else of add to cart");
	        	    	 noOftickets=1;
	        	    	 cart.setUser(user);
	        	    	 cart.setMovie(movie);
	        	    	 cart.setNooftickets(noOftickets);
	        	    	 cartRepo.save(cart);
	        	    }
	        	     
	        	     model.addAttribute("msg1","Added movie "+ "'"+movie.getName()+"'"+ " to cart");
	          }
	        
	        else {
	              model.addAttribute("msg1","Movie "+ "'"+movie.getName()+"'"+ " is disabled so cannot be added to cart");	
	             }
	        
	        	     String keyword=(String)session.getAttribute("keyword2");
	        	     List<Movie2> movies=movieService.searchMovies(keyword);
	        	     int sort=(Integer)session.getAttribute("sort");
	        	     String sortedBy=(String)session.getAttribute("sortedBy");
	        	   //  List<Movie2> sortedmovies=(List<Movie2>)session.getAttribute("sortedmovies");
	        	       List<Movie2> movies2=new ArrayList<Movie2>();  
	        	     
	        	     if(sort==1) {
	        	         
	        	    	 switch(sortedBy) {
	        	    	 
	        	    	 case "Genre": { movies2=movieService.sortByGenre(movies);
	        	    	                 break;
	        	    	               }
	        	    	 
	        	    	 case "Language" : { movies2=movieService.sortByLanguage(movies);
	        	    	                     break;
	        	    	                   }
	        	    	 
	        	    	 case "Date" : { movies2=movieService.sortByDate(movies);
	        	    	                 break;
	        	    	                }
	        	    	      
	        	    	          }   //End of switch
	        	    	 
	        	    	 
	                	     model.addAttribute("listofmovies",movies2);
	        	     }
	        	     
	        	     else {
	        	        	 model.addAttribute("listofmovies",movies);
	        	     }
	        	      
	        	     model.addAttribute("keyword",keyword);
	        	    // model.addAttribute("msg1","Added movie "+ "'"+movie.getName()+"'"+ " to cart");
	        	     return "customerDashboard";          
	          }
	          
              
	          
	          @PostMapping("/removefromCart")
	          public String removefromCart(HttpServletRequest req,Model model,HttpSession session) {
                        
	        	       int movieid=Integer.parseInt(req.getParameter("movieid"));
	        	       Users user=(Users)session.getAttribute("cuser");
	        	       
	        	       Movie2 movie=movie2Repo.findById(movieid).get();
	        	       
	        	       int count=cartRepo.deleteByMovieidAndUserid(movieid,user.getUid());
	        	       
	        	       if(count==0) {
	        	    	   model.addAttribute("msg1","Movie "+ movie.getName()+ " is not present in cart to remove");
	        	       }
	        	       
	        	       else {
	        	    	   model.addAttribute("msg1","Removed movie "+"'"+ movie.getName()+"'"+ " from cart");
	        	       }
	        	       String keyword=(String)session.getAttribute("keyword2");
	        	       List<Movie2> movies=movieService.searchMovies(keyword);
	        	       
	        	       int sort=(Integer)session.getAttribute("sort");
		        	    // List<Movie2> sortedmovies=(List<Movie2>)session.getAttribute("sortedmovies");
	        	       String sortedBy=(String)session.getAttribute("sortedBy");
	        	       List<Movie2> movies2=new ArrayList<Movie2>();
		        	     
		        	     if(sort==1) {
		        	    	 
		        	    	 switch(sortedBy) {
		        	    	 
		        	    	 case "Genre": { movies2=movieService.sortByGenre(movies);
		        	    	                 break;
		        	    	               }
		        	    	 
		        	    	 case "Language" : { movies2=movieService.sortByLanguage(movies);
		        	    	                     break;
		        	    	                   }
		        	    	 
		        	    	 case "Date" : { movies2=movieService.sortByDate(movies);
		        	    	                 break;
		        	    	                }
		        	    	      
		        	    	          }   //End of switch
		        	    	 
		        	    	      	    	 
		        	              model.addAttribute("listofmovies",movies2);
		        	     }
		        	     
		        	     else {
		        	    	 model.addAttribute("listofmovies",movies);
		        	     }
		        	     
	        	       //model.addAttribute("listofmovies",movies);
	        	       model.addAttribute("keyword", keyword);
	        	      
	        	       return "customerDashboard";  
	          }

	          
	          
	          @GetMapping("/viewcart")
	          public String viewCart(HttpSession session,Model model) {
	        	  
	        	  Users user1=(Users)session.getAttribute("cuser");
	        	  
	        	  List<Cart> carts=cartRepo.findByUserid(user1.getUid());
	        	  
	        	  model.addAttribute("listofcarts", carts);
	        	  
	        	  return "viewcart";
	        	  
	        	  
	          }
	          
               
	          @PostMapping("/remfromcart")
	          public String remfromcart(HttpServletRequest req,HttpSession session,Model model) {
	        	  
	        	    int movieid=Integer.parseInt(req.getParameter("movieid")); 
	        	    Users user=(Users)session.getAttribute("cuser");
	        	    Movie2 movie=movie2Repo.findById(movieid).get();
	        	    
	        	    cartRepo.deleteByMovieidAndUserid(movieid,user.getUid());
	        	    
	        	    List<Cart> carts=cartRepo.findByUserid(user.getUid());
	        	    
	        	    model.addAttribute("listofcarts",carts);
	        	    
                    model.addAttribute("msg","Removed movie "+"'"+ movie.getName()+"'" +" from cart");
	        	    return "viewcart";
	          }
	          
	          
	          
	          @GetMapping("/gotosearchform")
	          public String gotosearchForm(Model model) {
	        	  
	        	  model.addAttribute("listofmovies", null);
	        	  return "customerDashboard";
	          }
	          
	          
	          @GetMapping("/buyTickets")
	          public String buyTickets(HttpSession session, Model model) {
	        	  
	        	  System.out.println("Entered buy tickets");
                  
	        	  Users user=(Users)session.getAttribute("cuser");
	        	  
	        	  List<Cart> carts=cartRepo.findByUserid(user.getUid());
	        	  
	        	  float total_amt=0;
	        	  
	        	  for(Cart c: carts) {
	        		  
	        		  total_amt+=c.getMovie().getTicketprice()*c.getNooftickets();
	        		  
	        	  }
	        	  
	        	  model.addAttribute("listofcarts1",carts);
	        	  model.addAttribute("total_amount", total_amt);
	        	  session.setAttribute("tot_amt",total_amt);
	        	  return "buyTickets";
	        	  
	          }



}
