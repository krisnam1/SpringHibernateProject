package com.vastika.uis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "user_tbl")
public class User {

	@Id // the id is written on top of the column which we want to be a primary key, if
		// we want email as their primary key then
		// we put @Id on top of private String email
	@GeneratedValue(strategy = GenerationType.AUTO) // this is for autogenerated
	private int userId;

	@Column(name = "first_name") // if we do not want to change the name of the column that is not as we made in
									// this class
	//@Size(min = 2, max = 6, message = "Username must be between 2 and 6")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE) // sending the date format
	@Past(message = "DOB must be past date!!")
	@Column(name = "DOB")
	private Date dob;
	// @NotNull

	private String email;
	//@Max(value = 999, message = "mobile number must be 3-digits")
	@Column(name = "phone_number")
	private long phoneNumber;
	private String gender;
	@Column(name = "marital_status")
	private String maritalStatus;
	private String education;
	private String hobbies;
	// @OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	// fetchType.EAGER will show all the results where as LAZY will show as per user
	// inputs
	// @JoinTable(name = "user_address_tbl",
	// joinColumns=@JoinColumn(name="userid"),
	// inverseJoinColumns = @JoinColumn(name="address_id"))
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@Column(name = "user_name")
	private String userName;
	@NotNull
//	@Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$", message = "Invalid password, Try again!!!")
	private String password;
	private String imageUrl;

	// @OneToOne (cascade=CascadeType.MERGE)
	@OneToOne(cascade = CascadeType.MERGE)
	// @JoinColumn (name = "userId", referencedColumnName="id" )
	private Role role;

}
