package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountDetails {
	@Id
private String FormNo;
private String AccountType;
private String CardNo;
private String Pin;
private String ServicesRequired;
public String getFormNo() {
	return FormNo;
}
public void setFormNo(String formNo) {
	FormNo = formNo;
}
public String getAccountType() {
	return AccountType;
}
public void setAccountType(String accountType) {
	AccountType = accountType;
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
public String getServicesRequired() {
	return ServicesRequired;
}
public void setServicesRequired(String servicesRequired) {
	ServicesRequired = servicesRequired;
}
@Override
public String toString() {
	return "AccountDetails [FormNo=" + FormNo + ", AccountType=" + AccountType + ", CardNo=" + CardNo + ", Pin=" + Pin
			+ ", ServicesRequired=" + ServicesRequired + "]";
}


}
