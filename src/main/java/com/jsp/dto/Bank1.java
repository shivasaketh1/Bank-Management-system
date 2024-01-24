package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank1 {
	@Id
 private String formNo;
 private String name;
 private String fname;
 private String dob;
 private String gender;
 private String email;
 private String marital;
 private String address;
 private String city;
 private String pincode;
 private String state;
public String getFormNo() {
	return formNo;
}
public void setFormNo(String formNo) {
	this.formNo = formNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMarital() {
	return marital;
}
public void setMarital(String marital) {
	this.marital = marital;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
 
 
}
