package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdditonalDetails {
	@Id
   private String FormNo;
   private String Religion;
   private String Category;
   private String Income;
   private String Education;
   private String Occupation;
   private String PanNumber;
   private String AadharNumber;
   private String SeniorCitizen;
   private String ExistingAccount;
public String getFormNo() {
	return FormNo;
}
public void setFormNo(String formNo) {
	FormNo = formNo;
}
public String getReligion() {
	return Religion;
}
public void setReligion(String religion) {
	Religion = religion;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public String getIncome() {
	return Income;
}
public void setIncome(String income) {
	Income = income;
}
public String getEducation() {
	return Education;
}
public void setEducation(String education) {
	Education = education;
}
public String getOccupation() {
	return Occupation;
}
public void setOccupation(String occupation) {
	Occupation = occupation;
}
public String getPanNumber() {
	return PanNumber;
}
public void setPanNumber(String panNumber) {
	PanNumber = panNumber;
}
public String getAadharNumber() {
	return AadharNumber;
}
public void setAadharNumber(String aadharNumber) {
	AadharNumber = aadharNumber;
}
public String getSeniorCitizen() {
	return SeniorCitizen;
}
public void setSeniorCitizen(String seniorCitizen) {
	SeniorCitizen = seniorCitizen;
}
public String getExistingAccount() {
	return ExistingAccount;
}
public void setExistingAccount(String existingAccount) {
	ExistingAccount = existingAccount;
}
   
   
}
