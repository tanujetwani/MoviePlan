package org.simplilearn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Users {
	
	         @Id
	         @GeneratedValue(strategy=GenerationType.IDENTITY)
	         private int uid;
	         
	         private String uname;
	         private String upwd;
	         private String phone;
	         private String email;
	         private String userType;
	         
             
	         public Users() {}

            //Getters and Setters
			public int getUid() {
				return uid;
			}


			public void setUid(int uid) {
				this.uid = uid;
			}


			public String getUname() {
				return uname;
			}


			public void setUname(String uname) {
				this.uname = uname;
			}


			public String getUpwd() {
				return upwd;
			}


			public void setUpwd(String upwd) {
				this.upwd = upwd;
			}


			public String getPhone() {
				return phone;
			}


			public void setPhone(String phone) {
				this.phone = phone;
			}


			public String getEmail() {
				return email;
			}


			public void setEmail(String email) {
				this.email = email;
			}


			public String getUserType() {
				return userType;
			}


			public void setUserType(String userType) {
				this.userType = userType;
			}
	         
	         
	         
}
