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
public class OrderDetails {
	
	           @Id
	           @GeneratedValue(strategy=GenerationType.IDENTITY)
	           private int orderDetail_id;
	           
	           private int noOfTickets;
	           
	           @ManyToOne
	           @JoinColumn(name="order_id")
	           private Orders order;
	           
	           @OneToOne
	           @JoinColumn(name="movieid")
	           private Movie2 movie;
	           
	           private float amount;
	           
	           public OrderDetails() {}

	           
	           //Getters and Setters
			public int getOrderDetail_id() {
				return orderDetail_id;
			}

			public void setOrderDetail_id(int orderDetail_id) {
				this.orderDetail_id = orderDetail_id;
			}

			public int getNoOfTickets() {
				return noOfTickets;
			}

			public void setNoOfTickets(int noOfTickets) {
				this.noOfTickets = noOfTickets;
			}

			public Orders getOrder() {
				return order;
			}

			public void setOrder(Orders order) {
				this.order = order;
			}

			public Movie2 getMovie() {
				return movie;
			}

			public void setMovie(Movie2 movie) {
				this.movie = movie;
			}

			public float getAmount() {
				return amount;
			}

			public void setAmount(float amount) {
				this.amount = amount;
			}

			
			
	           
	           
}
