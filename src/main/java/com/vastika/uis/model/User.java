package com.vastika.uis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
@Table(name="user_tbl")
public class User {
	
	@Id//the id is written on top of the column which we want to be a primary key, if we want email as their primary key then 
	//we put @Id on top of private String email
	@GeneratedValue (strategy = GenerationType.AUTO)//this is for autogenerated
	private int userId;
	@Column(name = "first_name")//if we do not want to change the name of the column that is not as we made in this class
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE) //sending the date format
	@Column(name="DOB")
	private Date dob;
	private String email;
	@Column(name = "phone_number")
	private long phoneNumber;
	private String gender;
	@Column(name = "marital_status")
	private String maritalStatus;
	private String education;
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	//@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//fetchType.EAGER will show all the results where as LAZY will show as per user inputs
	//@JoinTable(name = "user_address_tbl", 
	//joinColumns=@JoinColumn(name="userid"), 
	//inverseJoinColumns = @JoinColumn(name="address_id"))
    
	private List<Address> address;
	
	
}
