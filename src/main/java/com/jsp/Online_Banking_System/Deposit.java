package com.jsp.Online_Banking_System;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jsp.dto.BankDeposit;

public class Deposit extends JFrame implements ActionListener{
	String pin;
	TextField field;
	JButton b1,b2;
	public Deposit(String pin) {
		this.pin=pin;
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("atm2.png"));
		Image image=icon.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);
		JLabel jLabel=new JLabel(icon2);
		jLabel.setBounds(-70, 0, 1550, 830);
		add(jLabel);
		JLabel jLabel1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("System",Font.BOLD,16));
		jLabel1.setBounds(460, 180, 400, 35);
		jLabel.add(jLabel1);
		field=new TextField();
		field.setBackground(new Color(65,125,128));
		field.setForeground(Color.WHITE);
		field.setBounds(460,230 ,320, 25);
		field.setFont(new Font("Raleway",Font.BOLD,22));
		jLabel.add(field);
		b1=new JButton("DEPOSIT");
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
	new Deposit("");
}

public void actionPerformed(ActionEvent e) {
	BankDeposit bankDeposit=new BankDeposit();
	bankDeposit.setPin(pin);
	Date date=new Date();
	bankDeposit.setDate(""+date);
	bankDeposit.setType("Deposit");
	bankDeposit.setAmount(field.getText());
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	if(e.getSource()==b1) {
		if(bankDeposit.getAmount().equals("")) {
			JOptionPane.showMessageDialog(b1, "PLZ ENTER THE AMOUNT TO DEPOSIT");
		}else {
			et.begin();
			em.persist(bankDeposit);
			et.commit();
			JOptionPane.showMessageDialog(b1,"Rs. "+bankDeposit.getAmount()+"  Deposited Successfully");
			setVisible(false);
			new Main_Center(bankDeposit.getPin());
		}
	}else if(e.getSource()==b2) {
		setVisible(false);
		new Main_Center(bankDeposit.getPin());
	}
	
}
}
