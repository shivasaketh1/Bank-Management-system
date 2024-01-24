package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jsp.dto.BankDeposit;

public class Withdarwl extends JFrame implements ActionListener{
	String pin;
	TextField field;
	JButton b1,b2;
 public Withdarwl(String pin) {
	 this.pin=pin;
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("atm2.png"));
		Image image=icon.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);
		JLabel jLabel=new JLabel(icon2);
		jLabel.setBounds(-70, 0, 1550, 830);
		add(jLabel);
		JLabel jLabel1=new JLabel("MAXIMUM WITHDARWAL IS RS.10,000");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("System",Font.BOLD,16));
		jLabel1.setBounds(460, 180, 700, 35);
		jLabel.add(jLabel1);
		JLabel jLabel2=new JLabel("PLEASE ENTER YOUR AMOUNT");
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setFont(new Font("System",Font.BOLD,16));
		jLabel2.setBounds(460, 220, 700, 35);
		jLabel.add(jLabel2);
		field=new TextField();
		field.setBackground(new Color(65,125,128));
		field.setForeground(Color.WHITE);
		field.setBounds(460,260 ,320, 25);
		field.setFont(new Font("Raleway",Font.BOLD,15));
		jLabel.add(field);
		b1=new JButton("WITHDARWAL");
		b1.setBackground(new Color(65,125,128));
		b1.setForeground(Color.WHITE);
		b1.setBounds(700, 362, 150, 35);
		b1.addActionListener(this);
		jLabel.add(b1);
		b2=new JButton("BACK");
		b2.setBackground(new Color(65,125,128));
		b2.setForeground(Color.WHITE);
		b2.setBounds(700, 406, 150, 35);
		b2.addActionListener(this);
		jLabel.add(b2);
		setLayout(null);
		setSize(1500, 1000);
		setLocation(0, 0);
		setVisible(true);
}
 public static void main(String[] args) {
	new Withdarwl("");
}
public void actionPerformed(ActionEvent e) {
	      String amount=field.getText();
	      Date date=new Date();
	      if(e.getSource()==b1) {
	      if(field.getText().equals("")) {
	    	  JOptionPane.showMessageDialog(b1,"Please enter the Amount you Want to withdarwal");
	      }else {
	    	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
	    		EntityManager em=emf.createEntityManager();
	    		EntityTransaction et=em.getTransaction();
	    		Query q=em.createQuery("select a from BankDeposit  a");
	    		List<BankDeposit> l=q.getResultList();
	    		int balance=0;
	    		for(BankDeposit b:l) {
	    			if(b.getType().equals("Deposit")) {
	    				balance+=Integer.parseInt(b.getAmount());
	    			}else {
	    				balance-=Integer.parseInt(b.getAmount());
	    			}
	    		}
	    		if(balance<Integer.parseInt(amount)) {
	    			JOptionPane.showMessageDialog(b1, "Insuffient Balance");
	    			return;
	    		}
	    		BankDeposit bankDeposit=new BankDeposit();
	    		bankDeposit.setPin(pin);
	    		bankDeposit.setDate(""+date);
	    		bankDeposit.setAmount(amount);
	    		bankDeposit.setType("Withdarwl");
	    		et.begin();
	    		em.persist(bankDeposit);
	    		et.commit();
	    		JOptionPane.showMessageDialog(b1, "Rs. "+amount+" Debited Successfully");
	    		setVisible(false);
	    		new Main_Center(pin); 
	      }}else if(e.getSource()==b2) {
	    	  setVisible(false);
	    	  new Main_Center(pin);
	      }
}
}
