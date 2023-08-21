package org.simplilearn.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.simplilearn.entities.Genre;

import org.simplilearn.entities.Movie2;
import org.simplilearn.repositories.GenreRepository;
import org.simplilearn.repositories.Movie2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

	    //MovieRepository movieRepo;
	    Movie2Repository movie2Repo;
	    GenreRepository genreRepo;
	    
	    @Autowired
	    public MovieServiceImpl(Movie2Repository movie2Repo,GenreRepository genreRepo) {
	    	
	    	//this.movieRepo=movieRepo;
	    	this.movie2Repo=movie2Repo;
	    	this.genreRepo=genreRepo;
	    }
	
	
	
	//@Override
	/*public List<Movie> searchMovies(String keyword) {
		
		    
		     String[] tokens=keyword.split("[:, +.-/]");
		     
		     for(int i=0; i<tokens.length ; i++) {
		    	 
		    	 System.out.println("Token :"+ tokens[i]);
		     }
		     
		     List<Movie> movies=new ArrayList<Movie>();
		     
		     for(int i=0; i<tokens.length ; i++) {
		    	 
		          System.out.println("i :"+ i);
	            
		          /*if(tokens[i].contains("/-:")) {
		        	  String[] tokens2=tokens[i].split("[:-/]");
		        	  
		        	  
		        	  for (int count=0; count<tokens2.length ;count++) {
		        	  List<Movie> movies3=movieRepo.findByKeyword(tokens2[i]); 
		        	  List<Movie> movies4=movies3;
		        	  movies3.retainAll(movies4);
		        	  }    	  
		          }
		          
		          else {*/
		        	  
	/*	    	 List<Movie> movies1=movieRepo.findByKeyword(tokens[i]);
		    	 
		         
		          
		       for(int j=0; j<movies1.size(); j++) {
		    	   
		    	   System.out.println("j :"+ j);
		    	    if(movies.contains(movies1.get(j))) {}
		    	    else {
		    	    	
		    	    	movies.add(movies1.get(j));
		    	    	}
		    	    
		    	    }  //End of inner for  
		    	   
		       } //End of outer for
		     
		     
		    
		
		
		return movies;
	} */
	
	
	@Override
	    public List<Movie2> searchMovies(String keyword) {
		
	    
	     String[] tokens=keyword.split("[:, +.-/]");
	     
	     for(int i=0; i<tokens.length ; i++) {
	    	 
	    	 System.out.println("Token :"+ tokens[i]);
	     }
	     
	     List<Movie2> movies=new ArrayList<Movie2>();
	     
	     for(int i=0; i<tokens.length ; i++) {
	    	 
	          System.out.println("i :"+ i);
           
	          /*if(tokens[i].contains("/-:")) {
	        	  String[] tokens2=tokens[i].split("[:-/]");
	        	  
	        	  
	        	  for (int count=0; count<tokens2.length ;count++) {
	        	  List<Movie> movies3=movieRepo.findByKeyword(tokens2[i]); 
	        	  List<Movie> movies4=movies3;
	        	  movies3.retainAll(movies4);
	        	  }    	  
	          }
	          
	          else {*/
	        	  
	    	 List<Movie2> movies1=movie2Repo.findByKeyword(tokens[i]);
	    	 
	         
	          
	       for(int j=0; j<movies1.size(); j++) {
	    	   
	    	   System.out.println("j :"+ j);
	    	    if(movies.contains(movies1.get(j))) {}
	    	    else {
	    	    	
	    	    	movies.add(movies1.get(j));
	    	    	}
	    	    
	    	    }  //End of inner for  
	    	   
	       } //End of outer for
	     
	         
	     //For Loop for Genre 
	     
	     for(int i=0; i<tokens.length; i++) {
	    	 
	    	 List<Integer> listofgenreid=genreRepo.findByGenreName(tokens[i]);
	    	 
	    	 for(int c=0; c<listofgenreid.size(); c++) {
	    		 
	    		 System.out.println("GenreId: " +listofgenreid.get(c));
	    	 }
	    	 
	    	 List<Movie2> movies2=movie2Repo.findByGenreId(listofgenreid);
	    	 
             
	    	 for(int j=0; j<movies2.size(); j++) {
	    	
	    	       	 
	    	       if(movies.contains(movies2.get(j))) {}
	    	       
	    	       else
	    	       {
	    	    	   movies.add(movies2.get(j));
	    	       }
	    		 
	    	 } //End of for inner Genre
	    	 
	     }	     
	    	return movies;
}


	
	
	    public  List<Movie2> sortByGenre(List<Movie2> movies){
	
	    	
	    	     if(movies.size()>0) {
                       
	    	    	 Collections.sort(movies,Movie2.MovieGenreComparator);
	    	     }
                
	    	     return movies;
	    }
	    
	    
	    public List<Movie2> sortByLanguage(List<Movie2> movies){
	    	
	    	   if(movies.size()>0) {
	    		   
	    		   Collections.sort(movies,Movie2.MovieLangComparator);
	    	   }
	    	   
	    	   return movies;
	    }
	    
	    
	    public List<Movie2> sortByDate(List<Movie2> movies){

	    	
	    	if(movies.size()>0) {
	    		
	    		Collections.sort(movies,Movie2.MovieDateComparator);
	    	}
	    	
	    	return movies;
	    }
}
