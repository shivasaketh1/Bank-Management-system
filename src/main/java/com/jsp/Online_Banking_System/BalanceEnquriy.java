package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.jsp.dto.BankDeposit;

public class BalanceEnquriy extends JFrame implements ActionListener {
	JLabel jLabel2;
	JButton b1;
	String pin;
   public BalanceEnquriy(String pin) {
	   this.pin=pin;
	   ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("atm2.png"));
		Image image=icon.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);
		JLabel jLabel=new JLabel(icon2);
		jLabel.setBounds(-70, 0, 1550, 830);
		add(jLabel);
		JLabel jLabel1=new JLabel("YOUR CURRENT BALANCE");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("System",Font.BOLD,16));
		jLabel1.setBounds(430, 180, 700, 35);
		jLabel.add(jLabel1);
		jLabel2=new JLabel();
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setFont(new Font("System",Font.BOLD,16));
		jLabel2.setBounds(430, 220, 700, 35);
		jLabel.add(jLabel2);
		b1=new JButton("Back");
		b1.setBackground(new Color(65,125,128));
		b1.setForeground(Color.WHITE);
		b1.setBounds(700, 406, 150, 35);
		b1.addActionListener(this);
		jLabel.add(b1);
        int balance=0;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Query q=em.createQuery("select a from BankDeposit  a where a.pin=?1");
		q.setParameter(1,pin);
		List<BankDeposit> l=q.getResultList();
		
		for(BankDeposit b:l) {
			if(b.getType().equals("Deposit")) {
				balance+=Integer.parseInt(b.getAmount());
			}else {
				balance-=Integer.parseInt(b.getAmount());
			}
		}
	   jLabel2.setText(""+Math.abs(balance));
	   setLayout(null);
		setSize(1500, 1000);
		setLocation(0, 0);
		setVisible(true);
}
   public static void main(String[] args) {
	new BalanceEnquriy("");
}
public void actionPerformed(ActionEvent e) {
	setVisible(false);
	new Main_Center(pin);
}
}
