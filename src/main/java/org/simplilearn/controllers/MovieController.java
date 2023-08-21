package org.simplilearn.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.simplilearn.entities.Movie2;
import org.simplilearn.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
	          
	          MovieService movieService;
	          
	          @Autowired
	          public MovieController(MovieService movieService) {
	        	  
	        	  this.movieService=movieService;
	          }
	          
	
	         @GetMapping("/searchkeyword")
              public String searchWithKey(HttpServletRequest req, Model model,HttpSession session) {
	        	 
	        	 String keywd=req.getParameter("keyword");
                 
	        	 List<Movie2> movies=movieService.searchMovies(keywd);
	        	 
	        	 if(movies.size()>0) {
	        		 
	        		 model.addAttribute("listofmovies",movies);
	        		 //model.addAttribute("keyword",keywd);
	        		 //session.setAttribute("sortmovies",movies);
	        	 }
	        	 
	        	 else {
	        		 
	        		model.addAttribute("msg", "No Search Results found for keyword "+"'"+ keywd+"'"); 
	        		model.addAttribute("listofmovies", null);
	        	 }
	        	 
	        	 model.addAttribute("keyword",keywd);
	        	 session.setAttribute("keyword2",keywd);
	        	 session.setAttribute("sort",0);
	        	 return "customerDashboard";
	         }


	          @GetMapping("/sortByGenre")
	          public String sortBygenre(HttpSession session,Model model) {
	        	  
	        	        String keyword=(String)session.getAttribute("keyword2");
	        	  
                	   // List<Movie2> moviestoSort=(List<Movie2>)session.getAttribute("sortmovies");
	        	        
	        	        List<Movie2> movies=movieService.searchMovies(keyword);
	        	        
	        	        List<Movie2> movies2=movieService.sortByGenre(movies);
                	    
                	   /* if(movies.size()>0) {
                	    	
                	         Collections.sort(movies,Movie2.MovieGenreComparator);
                	    }*/
                	    
                	    model.addAttribute("listofmovies",movies2);
                       //session.setAttribute("sortedmovies",movies);
                       session.setAttribute("sort",1);
                       session.setAttribute("sortedBy","Genre");
                	    model.addAttribute("keyword",keyword);
                        
                        return "customerDashboard";
                        
                	 }
	          
	          
	          @GetMapping("/sortByLanguage")
	          public String sortbylang(HttpSession session,Model model) {

	        	  String keyword=(String)session.getAttribute("keyword2");
	        	  
          	   // List<Movie2> moviestoSort=(List<Movie2>)session.getAttribute("sortmovies");
          	    
	        	  List<Movie2> movies=movieService.searchMovies(keyword);
                  
	        	  List<Movie2> movies2=movieService.sortByLanguage(movies);
	        	  /*if(movies.size()>0) {
          	    	
          	    	Collections.sort(movies,Movie2.MovieLangComparator);
          	    }*/
          	    
          	    model.addAttribute("listofmovies",movies2);
          	    //session.setAttribute("sortedmovies",movies);
                session.setAttribute("sort",1);
                session.setAttribute("sortedBy","Language");
          	    model.addAttribute("keyword",keyword);
                  
                  return "customerDashboard";

	          }

           
	          
	          @GetMapping("/sortByDate")
	          public String sortbyDate(HttpSession session,Model model) {
	        	  
	          
	          String keyword=(String)session.getAttribute("keyword2");
        	  
      	   // List<Movie2> moviestoSort=(List<Movie2>)session.getAttribute("sortmovies");
	          List<Movie2> movies=movieService.searchMovies(keyword);
	          
	          List<Movie2> movies2=movieService.sortByDate(movies);
      	    
            /*    if(movies.size()>0) {
      	        System.out.println("Entered Date if");
      	    	Collections.sort(movies,Movie2.MovieDateComparator);
      	    } */
      	    
      	    System.out.println("Outside Date com if");
      	    model.addAttribute("listofmovies",movies2);
      	  //  session.setAttribute("sortedmovies",movies);
            session.setAttribute("sort",1); 
            session.setAttribute("sortedBy","Date");
      	    model.addAttribute("keyword",keyword);
              
              return "customerDashboard";
	      
	          
	          }

	          
}








