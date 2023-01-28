/**
 * 
 */
package com.mjedli.testjanvier2023.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

/**
 * @author mjedli
 *
 */
@Document
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@NonNull
	private long id;
	
	private String lastname = "";
	private String firstname = "";
	private String nickname = "";
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String email = "";
	private String country = "";
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

}
