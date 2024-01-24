package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.jsp.dto.AccountDetails;
import com.jsp.dto.BankDeposit;
import com.jsp.dto.LogInDetails;

public class ChangePin extends JFrame implements ActionListener{
	String pin;
	JButton b1,b2;
	JPasswordField p1,p2;
   public ChangePin(String pin) {
	   this.pin=pin;
	   ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("atm2.png"));
		Image image=icon.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);
		JLabel jLabel=new JLabel(icon2);
		jLabel.setBounds(-70, 0, 1550, 830);
		add(jLabel);
		JLabel jLabel1=new JLabel("CHANGE YOUR PIN");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("System",Font.BOLD,25));
		jLabel1.setBounds(430, 160, 150, 35);
		jLabel.add(jLabel1);
		JLabel jLabel2=new JLabel("New PIN :");
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setFont(new Font("System",Font.BOLD,16));
		jLabel2.setBounds(430, 220, 150, 35);
		jLabel.add(jLabel2);
		p1=new JPasswordField();
		p1.setBackground(new Color(65,125,128));
		p1.setForeground(Color.WHITE);
		p1.setBounds(600,220 ,200, 25);
		p1.setFont(new Font("Raleway",Font.BOLD,22));
		jLabel.add(p1);
		
		JLabel jLabel3=new JLabel("Re-Enter New PIN :");
		jLabel3.setForeground(Color.WHITE);
		jLabel3.setFont(new Font("System",Font.BOLD,16));
		jLabel3.setBounds(420, 260, 400, 35);
		jLabel.add(jLabel3);
		
		p2=new JPasswordField();
		p2.setBackground(new Color(65,125,128));
		p2.setForeground(Color.WHITE);
		p2.setBounds(600,260 ,200, 25);
		p2.setFont(new Font("Raleway",Font.BOLD,22));
		jLabel.add(p2);
		
		
		b1=new JButton("CHANGE");
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
	
	public void actionPerformed(ActionEvent e) {
		String pin1=p1.getText();
		//System.out.println(pin1);
		String pin2=p2.getText();
		if(!pin1.equals(pin2)) {
			JOptionPane.showMessageDialog(null, "Entered PIN dose not match");
			return;
		}if(e.getSource()==b1) {
			if(p1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter NEW PIN");
				return;
			}if(p2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Re-Enter NEW PIN");
				return;
			}
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			Query q=em.createQuery("select a from AccountDetails a where a.Pin=?1");
			q.setParameter(1, pin);
			List<AccountDetails> l=q.getResultList();
		    for(AccountDetails details:l) {
		    	details.setPin(pin1);
		    	et.begin();
		    	em.merge(details);
				et.commit();
		    }
		    Query q1=em.createQuery("select a from LogInDetails a where a.Pin=?1");
			q1.setParameter(1, pin);
			List<LogInDetails> l1=q1.getResultList();
		    for(LogInDetails details:l1) {
		    	details.setPin(pin1);
		    	et.begin();
		    	em.merge(details);
				et.commit();
		    }
		    Query q2=em.createQuery("select a from BankDeposit a where a.pin=?1");
			q2.setParameter(1, pin);
			List<BankDeposit> l2=q2.getResultList();
		    for(BankDeposit details:l2) {
		    	details.setPin(pin1);
		    	et.begin();
		    	em.merge(details);
				et.commit();
		    }
			JOptionPane.showMessageDialog(b1,"Your New  "+pin1+"PIN Changed Successfully");
			setVisible(false);
			new Main_Center(pin1);
		}else if(e.getSource()==b2) {
			new Main_Center(pin);
			setVisible(false);
		}
	}
public static void main(String[] args) {
	new ChangePin("");
}
}
