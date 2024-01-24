package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankDeposit {
private String pin;
@Id
private String date;
private String amount;
private String Type;

public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "BankDeposit ["+date+" "+Type+" "+amount+"]";
}

}
