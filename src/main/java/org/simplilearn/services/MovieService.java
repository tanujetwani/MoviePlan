package org.simplilearn.services;

import java.util.List;


import org.simplilearn.entities.Movie2;

public interface MovieService {
	
	
	   public List<Movie2> searchMovies(String keyword);
	   
	   
	   public List<Movie2> sortByGenre(List<Movie2> movies);
	   
	   
	   public List<Movie2> sortByLanguage(List<Movie2> movies);
	   
	   public List<Movie2> sortByDate(List<Movie2> movies);

}
