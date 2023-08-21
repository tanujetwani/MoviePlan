package org.simplilearn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Genre {
	
	      @Id
	      @GeneratedValue(strategy=GenerationType.IDENTITY)
	      private int genreId;
	      
	      private String genreName;
	      
	      public Genre() {}

		public int getGenreId() {
			return genreId;
		}

		public void setGenreId(int genreId) {
			this.genreId = genreId;
		}

		public String getGenreName() {
			return genreName;
		}

		public void setGenreName(String genreName) {
			this.genreName = genreName;
		}
	      
	      

}
