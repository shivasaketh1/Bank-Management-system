package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.jsp.dto.Bank1;
import com.toedter.calendar.JDateChooser;

public class SinupPage1  extends JFrame implements ActionListener {
	Random random=new Random();
	JRadioButton r1,r2,r3,r4,r5;
	JDateChooser chooser;
	long l=((random.nextLong()%9000l)+1000l);
	String string=" "+Math.abs(l);
	JTextField t1,t2,t3,t5,t6,t7,t8;
	JButton button;
   public SinupPage1() {
	   ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank.png"));
		Image image=icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image);  
		JLabel im=new JLabel(icon2);
		im.setBounds(10, 10, 100, 100);
		add(im);
		
		JLabel jLabel=new JLabel("APPLICATION FORM NO :"+string);
		jLabel.setBounds(160, 20, 600, 40);
		jLabel.setFont(new Font("Raleway", Font.BOLD, 38));
		add(jLabel);
	   JLabel jLabel2=new JLabel("Page No : 1");
	   jLabel2.setFont(new Font("Raleway", Font.BOLD, 22));
	   jLabel2.setBounds(330, 60,600, 30);
	   add(jLabel2);
	   JLabel jLabel3=new JLabel("Personal Details");
	   jLabel3.setFont(new Font("Raleway", Font.BOLD, 22));
	   jLabel3.setBounds(300, 90,600, 30);
	   add(jLabel3);
	   
	   JLabel name=new JLabel("Name :");
	   name.setFont(new Font("Raleway", Font.BOLD, 20));
	   name.setBounds(100, 150,100, 30);
	   add(name);
	   
	   t1=new JTextField();
	   t1.setFont(new Font("Raleway", Font.BOLD, 15));
	   t1.setBounds(300, 150, 300, 30);
	   add(t1);
	   JLabel Fname=new JLabel("Father's.. :");
	   Fname.setFont(new Font("Raleway", Font.BOLD, 22));
	   Fname.setBounds(100, 200,100, 30);
	   add(Fname);
	   t2=new JTextField();
	   t2.setFont(new Font("Raleway", Font.BOLD, 15));
	   t2.setBounds(300, 200, 300, 30);
	   add(t2);
	   JLabel DOB=new JLabel("Date Of Birth");
	    DOB.setFont(new Font("Raleway", Font.BOLD, 20));
	   DOB.setBounds(100, 290,200, 30);
	   add(DOB);
	   chooser=new JDateChooser(); 
	   chooser.setForeground(new Color(105,105,105));
	   chooser.setBounds(300, 290, 300, 30);
	   add(chooser);
	   JLabel gen=new JLabel("Gender :");
	    gen.setFont(new Font("Raleway", Font.BOLD, 20));
	   gen.setBounds(100, 240,200, 30);
	   add(gen);
	   r1=new JRadioButton("Male");
	   r1.setBackground(new Color(222,255,228));
	   r1.setFont(new Font("Raleway", Font.BOLD, 14));
	   r1.setBounds(300, 240,60, 30);
	   add(r1);
	   r2=new JRadioButton("Female");
	   r2.setBackground(new Color(222,255,228));
	   r2.setFont(new Font("Raleway", Font.BOLD, 14));
	   r2.setBounds(450, 240,80, 30);
	   add(r2);
	   
	   ButtonGroup buttonGroup=new ButtonGroup();
	   buttonGroup.add(r1);
	   buttonGroup.add(r2);
	   
	   JLabel  email=new JLabel("E-mail :");
	   email.setFont(new Font("Raleway", Font.BOLD, 20));
	   email.setBounds(100, 340, 200, 30);
	   add(email);
	   t3=new JTextField();
	   t3.setFont(new Font("Raleway", Font.BOLD,14));
	   t3.setBounds(300, 340, 300, 30);
	   add(t3);
	   
	   JLabel ms=new JLabel("Marital Status :");
	   ms.setFont(new Font("Raleway", Font.BOLD, 20));
	   ms.setBounds(100, 390, 400, 30);
	   add(ms);
	   r3=new JRadioButton("Married");
	   r3.setBackground(new Color(222,255,228));
	   r3.setFont(new Font("Raleway", Font.BOLD, 14));
	   r3.setBounds(300,390,100, 30);
	   add(r3);
	   r4=new JRadioButton("Unmarried");
	   r4.setBackground(new Color(222,255,228));
	   r4.setFont(new Font("Raleway", Font.BOLD, 14));
	   r4.setBounds(450, 390,100, 30);
	   add(r4);
	   r5=new JRadioButton("Other");
	   r5.setBackground(new Color(222,255,228));
	   r5.setFont(new Font("Raleway", Font.BOLD, 14));
	   r5.setBounds(630, 390,100, 30);
	   add(r5);
	   ButtonGroup buttonGroup2=new ButtonGroup();
	   buttonGroup2.add(r3);
	   buttonGroup2.add(r4);
	   buttonGroup2.add(r5);
	   
	   JLabel add=new JLabel("Address :");
	   add.setFont(new Font("Raleway", Font.BOLD, 20));
	   add.setBounds(100, 440, 200, 30);
	   add(add);
	   t5=new JTextField();
	   t5.setFont(new Font("Raleway", Font.BOLD, 14));
	   t5.setBounds(300, 440, 300, 30);
	   add(t5);
	   
	   JLabel city=new JLabel("City :");
	   city.setFont(new Font("Raleway", Font.BOLD, 20));
	   city.setBounds(100, 490, 200, 30);
	   add(city);
	   t6=new JTextField();
	   t6.setFont(new Font("Raleway", Font.BOLD, 14));
	   t6.setBounds(300, 490, 300, 30);
	   add(t6);
	   JLabel pin=new JLabel("Pin Code :");
	   pin.setFont(new Font("Raleway", Font.BOLD, 20));
	   pin.setBounds(100, 540, 200, 30);
	   add(pin);
	   t7=new JTextField();
	   t7.setFont(new Font("Raleway", Font.BOLD, 14));
	   t7.setBounds(300, 540, 300, 30);
	   add(t7);
	   JLabel state=new JLabel("State :");
	   state.setFont(new Font("Raleway", Font.BOLD, 20));
	   state.setBounds(100, 590, 200, 30);
	   add(state);
	   t8=new JTextField();
	   t8.setFont(new Font("Raleway", Font.BOLD, 14));
	   t8.setBounds(300, 590, 300, 30);
	   add(t8);
	   
	   button=new JButton("Next");
	   button.setFont(new Font("Raleway", Font.BOLD, 14));
	   button.setBackground(Color.BLACK);
	   button.setForeground(Color.WHITE);
	   button.setBounds(620, 640, 80, 30);
	   button.addActionListener(this);
	   add(button);
	   

	   
	   getContentPane().setBackground(new Color(222,255,228));
	   setLayout(null);
	   setSize(760, 730);
	   setLocation(100, 0);
	   setResizable(false);
	   setVisible(true);
}
	
	public static void main(String[] args) {
		new SinupPage1();
	}

	public void actionPerformed(ActionEvent e) {
		Bank1 bank1=new Bank1();
		bank1.setFormNo(string);
		bank1.setName(t1.getText());
		bank1.setFname(t2.getText());
		bank1.setDob(((JTextField) chooser.getDateEditor().getUiComponent()).getText());
		if(r1.isSelected()) {
			bank1.setGender("Male");
		}else if(r2.isSelected()) {
			bank1.setGender("Female");
		}
		bank1.setEmail(t3.getText());
		if(r3.isSelected()) {
			bank1.setMarital("Married");
		}else if(r4.isSelected()) {
			bank1.setMarital("Unmarried");
		}else if(r5.isSelected()) {
			bank1.setMarital("others");
		}
		bank1.setAddress(t5.getText());
		bank1.setCity(t6.getText());
		bank1.setPincode(t7.getText());
		bank1.setState(t8.getText());
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
			
			if(bank1.getFormNo().equals("")||bank1.getFname().equals("")||bank1.getAddress().equals("")||bank1.getCity().equals("")||bank1.getDob().equals("")||bank1.getEmail().equals("")||bank1.getGender().equals("")||bank1.getMarital().equals("")||bank1.getName().equals("")||bank1.getPincode().equals("")||bank1.getState().equals("")) {
				JOptionPane.showMessageDialog(button, "fill form correctly");
			}else {
				et.begin();
				em.persist(bank1);
				et.commit();
				new Sinup2(bank1.getFormNo());
				setVisible(false);
			}
		
		
	}
}
