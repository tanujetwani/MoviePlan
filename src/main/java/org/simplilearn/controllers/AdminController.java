package org.simplilearn.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Genre;
//import org.simplilearn.entities.Movie;
import org.simplilearn.entities.Movie2;
import org.simplilearn.repositories.GenreRepository;
import org.simplilearn.repositories.Movie2Repository;
//import org.simplilearn.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
             Movie2Repository movie2Repo;
             GenreRepository genreRepo;
             
             @Autowired
             public  AdminController(Movie2Repository movie2Repo,GenreRepository genreRepo) {
            	 
            	 this.movie2Repo=movie2Repo;
            	 this.genreRepo=genreRepo;
             }
            
             
	        @GetMapping("/addGenre")
	        public String addGenre() {
	        	
	        	return "addGenre";
	        }
	        
	        
	        @PostMapping("/addmovieGenres")
	        public String addMovie(HttpServletRequest req,Model model) {
               
	        /*	   String name=req.getParameter("name");
	        	   String language=req.getParameter("language");
	        	   String genre=req.getParameter("genre");
	        	   String description=req.getParameter("description");
	        	   LocalDate date=LocalDate.parse(req.getParameter("Date"));
	        	   LocalTime time=LocalTime.parse(req.getParameter("Time"));
	        	   String available=req.getParameter("available");
	        	   float price=Float.parseFloat(req.getParameter("price"));
	        	   
	        	   Movie movie=new Movie();
	        	   movie.setName(name);
	        	   movie.setLanguage(language);
	        	   movie.setGenre(genre);
	        	   movie.setDescription(description);
	        	   movie.setShowDate(date);
	        	   movie.setShowTimings(time);
	        	   movie.setIsAvailable(available);
	        	   movie.setTicketprice(price);*/
	        	
	        	   String genreName=req.getParameter("genrename");
	        	   List<Integer> g_id=genreRepo.findByGenreName(genreName);
	        	   
	        	   if(g_id.size()>0) {
	        		   
	        		   model.addAttribute("msg","Genre '"+genreName+ "' already exists in database");
	        		   return "addGenre";
	        		   
	        	   }
	        	   
	        	   else {
	        	   System.out.println("Name: "+ genreName);
	        	   Genre genre=new Genre();
	        	   genre.setGenreName(genreName);
	        	   System.out.println("Genre Name:"+ genre.getGenreName());
	        	   genreRepo.save(genre);
	        	   System.out.println("Saved Genre:");
	        	   //movie2Repo.save(movie);
	        	   model.addAttribute("msg","Genre "+ "'"+genreName +"'"+ " added successfully");
	        	   return "addGenre";
	        	   }
	        	   
	        	   
	        		   
	        	   
	        	
	        }
	        
	        
	        @GetMapping("/gotoadminhome")
	        public String gotoadminhome() {
	        	
	        	return "adminDashboard";
	        }
             
	        @GetMapping("/removeGenre")
	        public String removeGenre() {
	        
	        	return "removeGenre";
	        }
	        
            
	        @PostMapping("remGenreByid")
	        public String remByid(HttpServletRequest req,Model model) {
	               
	        	int id=Integer.parseInt(req.getParameter("genreid"));
	        	
	        	int exception=0,count=-1;
	        	
	        	try {
	        		      
	        		count=genreRepo.deleteById(id);
	        	}
	        	catch(Exception e) {
	        		
	        		exception=1;
	        	}
	            
	        	if(exception==1) {
	        		
	        		model.addAttribute("msg","Cannot remove genre with id "+"'"+ id +"'"+ " as there are entries of this genre in 'movie2' table");
	        	}
	        	
	        	else if(count==0) {
	        		
	        		model.addAttribute("msg","Genre with id "+"'"+ id +"'"+ " does not exist in database");
	        	}
	        	
	        	else {
	        	       
	        		model.addAttribute("msg","Genre with id "+"'"+id +"'"+ " removed successfully");
	        		
	        	}
	        		return "removeGenre";
	        		
	        }
	        
	        
	        @PostMapping("/remGenreByName")
	        public String remByName(HttpServletRequest req,Model model) {
	        	
	                      String genreName=req.getParameter("genreName");
	                       int exception=0, count=-1;
	                       
	                       try {
	                    	   
	                    	   count=genreRepo.deleteByGenreName(genreName);
	                       }
	        	           catch(Exception e) {
	        	        	   
	        	        	   exception=1;
	        	           }
	                       
	                       if(exception==1) {
	                    	   model.addAttribute("msg","Cannot remove Genre "+"'"+genreName+"'"+" as there are movies with this genre in 'movies2' table");
	                       }
	                       else if(count==0) {
	                    	
	                    	   model.addAttribute("msg","Genre with name "+"'"+genreName+"'"+ " does not exist in database");
	                       }
	                       else {
	                    	   model.addAttribute("msg", "Genre with name "+"'"+ genreName +"'"+ " removed successfully");
	                       }
	                       
	                       return "removeGenre";
	        }
	        

	        
	        
	                     @GetMapping("/editDetails")
	                     public String showedit(Model model) {
	                    	 model.addAttribute("movie",null);
	                    	 return "editDetails";
	                     }
	        
	        
	        
	                    @GetMapping("/searchMovie")
	                    public String searchMovie(HttpServletRequest req,HttpSession session,Model model) {
                                    
	                    	int id=Integer.parseInt(req.getParameter("movieId"));
	                    	session.setAttribute("movieid",id);
	                    	int exception=0;
	                        Movie2 movie=new Movie2();	
	                    	try {
	                    	movie=movie2Repo.findById(id).get();
	                    	}
	                    	catch(Exception e) {
	                    		
	                    		exception=1;
	                    	}
	                    	
	                    	if(exception==1) {
	                    		
	                    		model.addAttribute("msg"," Movie with id "+ id + " does not exist");
	                    		
	                    	}
	                    	
	                    	
	                    	else
	                    	{
	                    		model.addAttribute("movie", movie);	
	                    	}
	                           
	                    	return "editDetails";
	                    }
	        
	                    
	                    
	                    
	                    @PostMapping("/editMovieDetails")
	                    public String editMovieDet(HttpServletRequest req,HttpSession session,Model model) {
	                    	
	                    	int id=(Integer)session.getAttribute("movieid");
                            Movie2 movie=movie2Repo.findById(id).get();
                            
	                    	System.out.println("Entered edit Details");
	                    	String name=req.getParameter("mname");
	                    	String language=req.getParameter("language");
	                    	String description=req.getParameter("description");
	                    	System.out.println("Description:"+ description);
	                    	String showDate=req.getParameter("showDate");
	                    	LocalDate date=null;
	                    	if(showDate.equals("")) {}
	                    	else {
	                    	 date=LocalDate.parse(req.getParameter("showDate"));
	                    	 movie.setShowDate(date);
	                    	}
	                    	
	                    	System.out.println("Date :"+ date);
	                    	String stime=req.getParameter("ShowTime");
	                    	LocalTime showTime=null;
	                    	if(stime.equals("")) {}
	                    	else {
	                    	 showTime=LocalTime.parse(req.getParameter("ShowTime"));
	                    	 movie.setShowTime(showTime);
	                    	 }
	                    	System.out.println("Time: "+ showTime);
	                    	
	                    	String tprice=req.getParameter("price");
	                    	if(tprice.equals("")) {}
	                    	else {
	                    	float ticketprice=Float.parseFloat(req.getParameter("price"));
	                    	movie.setTicketprice(ticketprice);
	                    	}
	                    	
                             
                             if(name.equals("")) {}
                             else {movie.setName(name);}
                             
                             if(language.equals("")) {}
                             else { movie.setLanguage(language);}
                             
                             if(description.equals("")) {}
                             else { movie.setDescription(description);}
                             
                           /*  if(date==null) {}
                             else { movie.setShowDate(date);}
                             
                             if(showTime==null) {}
                             
                             else { movie.setShowTime(showTime);}*/
                             
                             
                             movie2Repo.save(movie);
                             
                             model.addAttribute("msg","Movie with id "+ id + " edited successfully");
                             return "editDetails";
	                    }
	                    
	                    
                       
	                    @GetMapping("/enableorDisable")
	                    public String enableShow(Model model) {
	                    	model.addAttribute("enablemovie",null);
	                    	return "enable";
	                    }

                         
	                    @GetMapping("/searchMovies")
	                    public String searchMovies2(HttpServletRequest req,HttpSession session, Model model) {
	                    
	                    	int id=Integer.parseInt(req.getParameter("movieid"));
                            session.setAttribute("mid",id);	                    	
	                    	int exception=0;
	                    	Movie2 movie=new Movie2();
	                    	try {
	                    		
	                    		 movie=movie2Repo.findById(id).get();
	                    	}
	                    	catch(Exception e) {
	                    		
	                    		exception=1;
	                    	}
	                    	
	                    	if(exception==1) {
	                    		
	                    		model.addAttribute("msg", "Movie with id "+ id +" does not exist");
	                    		
	                    	}
	                    	else {
	                    		
	                    		model.addAttribute("enablemovie", movie);
	                    	}
	                    
	                    	return "enable";
	                    }

                         
	                    @PostMapping("/enableMovies")
	                    public String enableMovies(HttpServletRequest req,Model model,HttpSession session) {
                                   
	                    	boolean enable=Boolean.parseBoolean(req.getParameter("enableMovies"));
                            int id=(Integer)session.getAttribute("mid");	                    	
	                    	
	                    	Movie2 movie=movie2Repo.findById(id).get();
	                    	
	                    	//model.addAttribute("movie",movie);
	                    	movie.setEnable(enable);
	                    	
	                    	movie2Repo.save(movie);
                            
	                    	if(enable==true) {
	                    	model.addAttribute("msg","Movie with id "+ id + " and name as "+ movie.getName() + " is enabled");
	                    	}
	                    	
	                    	else {
	                    		model.addAttribute("msg","Movie with id "+ id + " and name as "+ movie.getName()+ " is disabled");
	                    	}
	                    	
	                    	//model.addAttribute("enablemovie",movie);
                           
	                    	return "enable";
	                    }

}
