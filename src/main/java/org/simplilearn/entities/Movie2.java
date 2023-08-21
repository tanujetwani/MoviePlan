package org.simplilearn.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Table(name="movie2")
@AllArgsConstructor
public class Movie2 {
	
	        @Id
	        @GeneratedValue(strategy=GenerationType.IDENTITY)
	        private int movieId;
	        
	        private String name;
	        
	        private String language;
	        private String description;
	        
	        @OneToOne
	        @JoinColumn(name="genreId")
	        private Genre genre;
	        
	        private LocalDate showDate;
	        
	        private LocalTime showTime;
	        
	        private float ticketprice;
	        
	        @Column(nullable=false, columnDefinition="TINYINT(1)")
	        private boolean enable;
            
	        
	        public Movie2() {}
	        
	        //Getters And Setters
	        
			public int getMovieId() {
				return movieId;
			}

			public void setMovieId(int movieId) {
				this.movieId = movieId;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getLanguage() {
				return language;
			}

			public void setLanguage(String language) {
				this.language = language;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public Genre getGenre() {
				return genre;
			}

			public void setGenre(Genre genre) {
				this.genre = genre;
			}

			public LocalDate getShowDate() {
				return showDate;
			}

			public void setShowDate(LocalDate showDate) {
				this.showDate = showDate;
			}

			public LocalTime getShowTime() {
				return showTime;
			}

			public void setShowTime(LocalTime showTime) {
				this.showTime = showTime;
			}

			public float getTicketprice() {
				return ticketprice;
			}

			public void setTicketprice(float ticketprice) {
				this.ticketprice = ticketprice;
			}

			public boolean getEnable() {
				return enable;
			}

			public void setEnable(boolean enable) {
				this.enable = enable;
			}
	        
	        
	        
			public static Comparator<Movie2> MovieGenreComparator=new Comparator<Movie2>() {
		     	
		     	
		     	
		     	public int compare(Movie2 m1, Movie2 m2) {
		     	
		     		String genre1=m1.getGenre().getGenreName();
		     		String genre2=m2.getGenre().getGenreName();
		     		
		     		return (genre1.compareToIgnoreCase(genre2));
		     		
		     	}
		     	
		     };	        

		     
		     public static Comparator<Movie2> MovieLangComparator=new Comparator<Movie2>() {
		       	
		       	
		       	
		       	public int compare(Movie2 m1, Movie2 m2) {
		       	
		       		String language1=m1.getLanguage();
		       		String language2=m2.getLanguage();
		       		
		       		return (language1.compareToIgnoreCase(language2));
		       		
		       	}
		       	
		       };
		       
         
		       
		       public static Comparator<Movie2> MovieDateComparator=new Comparator<Movie2>() {
		        	
		        	
		        	
		        	public int compare(Movie2 m1, Movie2 m2) {
		        	
		        		LocalDate date1=m1.getShowDate();
		        		LocalDate date2=m2.getShowDate();
		        		
		        		return (date1.compareTo(date2));
		        		
		        	}
		        	
		        };
	        

}
