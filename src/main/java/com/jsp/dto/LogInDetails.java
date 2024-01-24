package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LogInDetails {
	@Id
private String FormNo;
private String CardNo;
private String Pin;
public String getFormNo() {
	return FormNo;
}
public void setFormNo(String formNo) {
	FormNo = formNo;
}
public String getCardNo() {
	return CardNo;
}
public void setCardNo(String cardNo) {
	CardNo = cardNo;
}
public String getPin() {
	return Pin;
}
public void setPin(String pin) {
	Pin = pin;
}

}
