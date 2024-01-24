package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.jsp.dto.AccountDetails;
import com.jsp.dto.LogInDetails;

public class Sinup3 extends JFrame implements ActionListener {
	String num;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6;
	JButton b1,b2;
  public Sinup3(String num) {
	  ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank.png"));
		Image image=icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);  
		JLabel im=new JLabel(icon2);
		im.setBounds(10, 10, 100, 100);
		add(im);
		this.num=num;
		JLabel l=new JLabel("Form No :"+num);
    	l.setFont(new Font("Raleway",Font.BOLD, 20));
    	l.setBounds(530, 5, 200, 30);
    	add(l);
    	JLabel l1=new JLabel("Page No : 3");
    	l1.setFont(new Font("Raleway",Font.BOLD, 20));
    	l1.setBounds(310, 30, 150, 30);
    	add(l1);
    	JLabel l2=new JLabel("Account Details");
    	l2.setFont(new Font("Raleway",Font.BOLD, 20));
    	l2.setBounds(290, 55, 200, 30);
    	add(l2);
    	JLabel l3=new JLabel("Account Type :");
    	l3.setFont(new Font("Raleway",Font.BOLD, 18));
    	l3.setBounds(100, 130, 200, 30);
    	add(l3);
    	r1=new JRadioButton("Saving Account");
    	r1.setBackground(new Color(215,252,252));
    	r1.setFont(new Font("Raleway",Font.BOLD, 12));
    	r1.setBounds(100, 170, 120, 30);
    	add(r1);
    	r2=new JRadioButton("Fixed Deposit Account");
    	r2.setBackground(new Color(215,252,252));
    	r2.setFont(new Font("Raleway",Font.BOLD, 12));
    	r2.setBounds(350, 170, 160, 30);
    	add(r2);
    	r3=new JRadioButton("Current Account");
    	r3.setBackground(new Color(215,252,252));
    	r3.setFont(new Font("Raleway",Font.BOLD, 12));
    	r3.setBounds(100, 220, 120, 30);
    	add(r3);
    	r4=new JRadioButton("Recurring Deposit Account");
    	r4.setBackground(new Color(215,252,252));
    	r4.setFont(new Font("Raleway",Font.BOLD, 12));
    	r4.setBounds(350, 220, 180, 30);
    	add(r4);
    	ButtonGroup buttonGroup =new ButtonGroup();
    	buttonGroup.add(r1);
    	buttonGroup.add(r2);
    	buttonGroup.add(r3);
    	buttonGroup.add(r4);
    	JLabel l4=new JLabel("Card Number :");
    	l4.setFont(new Font("Raleway",Font.BOLD, 18));
    	l4.setBounds(100, 270, 200, 30);
    	add(l4);
    	JLabel l5=new JLabel("(Your 16-Digit CardNumber)");
    	l5.setFont(new Font("Raleway",Font.BOLD, 12));
    	l5.setBounds(100, 290, 200, 30);
    	add(l5);
    	JLabel l6=new JLabel("XXXX-XXXX-XXXX-3421");
    	l6.setFont(new Font("Raleway",Font.BOLD, 18));
    	l6.setBounds(330, 270, 250, 30);
    	add(l6);
    	JLabel l7=new JLabel("(It would appear on Atm card/cheque Book and Statements)");
    	l7.setFont(new Font("Raleway",Font.BOLD, 12));
    	l7.setBounds(330, 290, 500, 30);
    	add(l7);
    	JLabel l8=new JLabel("PIN :");
    	l8.setFont(new Font("Raleway",Font.BOLD, 18));
    	l8.setBounds(100, 330, 200, 30);
    	add(l8);
    	JLabel l9=new JLabel("XXXX");
    	l9.setFont(new Font("Raleway",Font.BOLD, 18));
    	l9.setBounds(330, 330, 250, 30);
    	add(l9);
    	JLabel l10=new JLabel("(4-digit Password)");
    	l10.setFont(new Font("Raleway",Font.BOLD, 12));
    	l10.setBounds(100, 350, 300, 30);
    	add(l10);
    	JLabel l11=new JLabel("Services Required :");
    	l11.setFont(new Font("Raleway",Font.BOLD, 18));
    	l11.setBounds(100, 380, 250, 30);
    	add(l11);
    	c1=new JCheckBox("ATM CARD");
    	c1.setBackground(new Color(215,252,252));
    	c1.setFont(new Font("Raleway",Font.BOLD, 14));
    	c1.setBounds(100, 430, 200, 30);
    	add(c1);
    	c2=new JCheckBox("Internet Banking");
    	c2.setBackground(new Color(215,252,252));
    	c2.setFont(new Font("Raleway",Font.BOLD, 14));
    	c2.setBounds(350, 430, 200, 30);
    	add(c2);
    	c3=new JCheckBox("Mobile Banking");
    	c3.setBackground(new Color(215,252,252));
    	c3.setFont(new Font("Raleway",Font.BOLD, 14));
    	c3.setBounds(100, 480, 200, 30);
    	add(c3);
    	c4=new JCheckBox("Email Alerts");
    	c4.setBackground(new Color(215,252,252));
    	c4.setFont(new Font("Raleway",Font.BOLD, 14));
    	c4.setBounds(350, 480, 200, 30);
    	add(c4);
    	c5=new JCheckBox("Cheque Book");
    	c5.setBackground(new Color(215,252,252));
    	c5.setFont(new Font("Raleway",Font.BOLD, 14));
    	c5.setBounds(100, 530, 200, 30);
    	add(c5);
    	c6=new JCheckBox("E-Statement");
    	c6.setBackground(new Color(215,252,252));
    	c6.setFont(new Font("Raleway",Font.BOLD, 14));
    	c6.setBounds(350, 530, 200, 30);
    	add(c6);
    	JCheckBox box=new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowlege.",true);
    	box.setBackground(new Color(215,252,252));
    	box.setFont(new Font("Raleway",Font.BOLD, 12));
    	box.setBounds(100, 580, 600, 30);
    	add(box);
    	b1=new JButton("Submit");
    	b1.setFont(new Font("Raleway",Font.BOLD, 12));
    	b1.setBackground(Color.BLACK);
    	b1.setForeground(Color.WHITE);
    	b1.setBounds(250,630 ,100, 30);
    	b1.addActionListener(this);
    	add(b1);
    	b2=new JButton("Cancel");
    	b2.setFont(new Font("Raleway",Font.BOLD, 12));
    	b2.setBackground(Color.BLACK);
    	b2.setForeground(Color.WHITE);
    	b2.setBounds(400,630,100,30);
    	b2.addActionListener(this);
    	add(b2);
		 getContentPane().setBackground(new Color(215,252,252));
	  	   setLayout(null);
	  	   setSize(750, 730);
	  	   setLocation(100, 0);
	  	   setResizable(false);
	  	   setVisible(true);
}
  public static void main(String[] args) {
	new Sinup3("");
}
public void actionPerformed(ActionEvent e) {
	AccountDetails details=new AccountDetails();
	LogInDetails details2=new LogInDetails();
	details.setFormNo(num);
	details2.setFormNo(num);
	if(r1.isSelected()) {
		details.setAccountType("Saving Account");
	}else if(r2.isSelected()) {
		details.setAccountType("Fixed Deposit Account");
	}else if(r3.isSelected()) {
		details.setAccountType("Current Account");
	}else if(r4.isSelected()) {
		details.setAccountType("Recurring Deposit Account");
	}
	Random random=new Random();
	long l=(random.nextLong()% 90000000l)+1409963000000000l;
	long l1=Math.abs(l);
	details.setCardNo(""+l1);
	details2.setCardNo(""+l1);
    long m=(random.nextLong()%9000l)+1000l;
    long m2=Math.abs(m);
    details.setPin(""+m2);
    details2.setPin(""+m2);
	String s="";
	if(c1.isSelected()) {
		s=s+"ATM CARD"+","; 	
	}else if(c2.isSelected()) {
		s+="Internet Banking"+",";
	}else if(c3.isSelected()) {
		s+="Mobile Banking"+",";
	}else if(c4.isSelected()) {
		s+="Email Alerts"+",";
	}else if(c5.isSelected()) {
		s+="Cheque Book"+",";
	}else if(c6.isSelected()) {
		s+="E-Statement"+",";
	}
	details.setServicesRequired(s);
	if(e.getSource()==b1) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	if(details.getFormNo().equals("")||details.getAccountType().equals("")||details.getCardNo().equals("")||details.getPin().equals("")||details.getServicesRequired().equals("")) {
		JOptionPane.showMessageDialog(b1, "fill form correctly");
	}else {
		et.begin();
		em.persist(details);
		em.persist(details2);
		et.commit();
		JOptionPane.showMessageDialog(b1,"Card Number :"+l1+"\n PIN : "+m2); 
		new Deposit(""+m2);
		setVisible(false);
	}}else if(e.getSource()==b2) {
		System.exit(0);
	}
}
}
