package org.simplilearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Cart {
	
	           @Id
	           @GeneratedValue(strategy=GenerationType.IDENTITY)
	           private int cartid;
	           
	           private int nooftickets;
	           
	           @ManyToOne(cascade=CascadeType.MERGE)
	           @JoinColumn(name="userid")
	           private Users user;
	           
	           @OneToOne(cascade=CascadeType.ALL)
	           @JoinColumn(name="movieid")
	           private Movie2 movie;
	
	           public Cart() {}

			public int getCartid() {
				return cartid;
			}

			public void setCartid(int cartid) {
				this.cartid = cartid;
			}

	
	

			public Users getUser() {
				return user;
			}

			public void setUser(Users user) {
				this.user = user;
			}

			public Movie2 getMovie() {
				return movie;
			}

			public void setMovie(Movie2 movie) {
				this.movie = movie;
			}

			public int getNooftickets() {
				return nooftickets;
			}

			public void setNooftickets(int nooftickets) {
				this.nooftickets = nooftickets;
			}
	           
	           
	            

}
