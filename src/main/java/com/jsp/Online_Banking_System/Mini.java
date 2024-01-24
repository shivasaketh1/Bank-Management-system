package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jsp.dto.BankDeposit;
import com.jsp.dto.LogInDetails;

public class Mini extends JFrame implements ActionListener{
	String pin;
	JButton b1;
	Mini(String pin){
		this.pin=pin;
		JLabel l=new JLabel("YOUR'S BANK");
		l.setFont(new Font("System",Font.BOLD,20));
		l.setBounds(125, 20,150, 35);
		add(l);
		JLabel l1=new JLabel();
		l1.setFont(new Font("Raleway",Font.BOLD,12));
		l1.setBounds(30, 80,400, 35);
		add(l1);
		JLabel l2=new JLabel();
		l2.setFont(new Font("Raleway",Font.BOLD,11));
		l2.setBounds(30,100,400, 300);
		add(l2);
		JLabel l3=new JLabel();
		l3.setFont(new Font("Raleway",Font.BOLD,12));
		l3.setBounds(30, 400,200,35);
		add(l3);
		b1=new JButton("EXIT");
		b1.setFont(new Font("Raleway",Font.BOLD,14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(280, 500, 80, 30);
		b1.addActionListener(this);
		add(b1);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Query q=em.createQuery("select a from LogInDetails  a where a.Pin=?1");
		q.setParameter(1,pin);
		List<LogInDetails> details=q.getResultList();
		for(LogInDetails details2:details) {
			l1.setText("Card Number :"+details2.getCardNo().substring(0,4)+"XXXXXXXX"+details2.getCardNo().substring(12));
		}
		Query q1=em.createQuery("select a from BankDeposit  a where a.pin=?1");
		q1.setParameter(1,pin);
		List<BankDeposit> d=q1.getResultList();
		int balance=0;
		for(BankDeposit bank:d) {
			l2.setText(l2.getText()+"<html>"+bank.getDate()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+bank.getType()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+bank.getAmount()+"<br><br><html>");
			//l2.setText(bank.getDate()+"     "+bank.getType()+"     "+bank.getAmount());
			System.out.println(bank.toString());
			
			if(bank.getType().equals("Deposit")) {
				balance+=Integer.parseInt(bank.getAmount());
			}else {
				balance-=Integer.parseInt(bank.getAmount());
			}

		}
		l3.setText("Your Total Acount Balance :- "+balance);
		getContentPane().setBackground(new Color(200,200,200));
		setSize(400,600);
		setLocation(20,20);
		setLayout(null);
		setVisible(true);
	}
   public static void main(String[] args) {
	new Mini("");
}
public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new Main_Center(pin);
}
}
