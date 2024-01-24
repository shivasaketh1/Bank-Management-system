package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jsp.dto.BankDeposit;

public class FastCash extends JFrame implements ActionListener {
	String pin;
	JButton b1,b2,b3,b4,b5,b6,b7;
	public FastCash(String pin) {
		this.pin=pin;
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("atm2.png"));
		Image image=icon.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);
		JLabel jLabel=new JLabel(icon2);
		jLabel.setBounds(-70, 0, 1550, 830);
		add(jLabel);
		JLabel jLabel1=new JLabel("SELECT WITHDRAWL AMOUNT");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("System",Font.BOLD,25));
		jLabel1.setBounds(450, 160, 400, 35);
		jLabel.add(jLabel1);
		b1=new JButton("Rs. 100");
		b1.setBackground(new Color(65,125,128));
		b1.setForeground(Color.WHITE);
		b1.setBounds(420, 270, 150, 35);
		b1.addActionListener(this);
		jLabel.add(b1);
		b2=new JButton("Rs. 500");
		b2.setBackground(new Color(65,125,128));
		b2.setForeground(Color.WHITE);
		b2.setBounds(700, 270, 150, 35);
		b2.addActionListener(this);
		jLabel.add(b2);
		b3=new JButton("Rs. 1000");
		b3.setBackground(new Color(65,125,128));
		b3.setForeground(Color.WHITE);
		b3.setBounds(420, 318, 150, 35);
		b3.addActionListener(this);
		jLabel.add(b3);
		b4=new JButton("Rs. 2000");
		b4.setBackground(new Color(65,125,128));
		b4.setForeground(Color.WHITE);
		b4.setBounds(700, 318, 150, 35);
		b4.addActionListener(this);
		jLabel.add(b4);
		b5=new JButton("Rs. 5000");
		b5.setBackground(new Color(65,125,128));
		b5.setForeground(Color.WHITE);
		b5.setBounds(420, 362, 150, 35);
		b5.addActionListener(this);
		jLabel.add(b5);
		b6=new JButton("Rs. 10000");
		b6.setBackground(new Color(65,125,128));
		b6.setForeground(Color.WHITE);
		b6.setBounds(700, 360, 150, 35);
		b6.addActionListener(this);
		jLabel.add(b6);
		b7=new JButton("BACK");
		b7.setBackground(new Color(65,125,128));
		b7.setForeground(Color.WHITE);
		b7.setBounds(700, 406, 150, 35);
		b7.addActionListener(this);
		jLabel.add(b7);
		
		setLayout(null);
		setSize(1500, 1000);
		setLocation(0, 0);
		setVisible(true);

	}
public static void main(String[] args) {
	new FastCash("");
}
public void actionPerformed(ActionEvent e) {
  if(e.getSource()==b7) {
	  setVisible(false);
	  new Main_Center(pin);
  }else {
	  String amount=((JButton)e.getSource()).getText().substring(4);
	  Date date=new Date();
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
  }
}
}
