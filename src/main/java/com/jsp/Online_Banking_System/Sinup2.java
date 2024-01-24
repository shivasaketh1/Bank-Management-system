package com.jsp.Online_Banking_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;

import com.jsp.dto.AdditonalDetails;

public class Sinup2 extends JFrame implements ActionListener {
	static String num;
	JButton next;
	JComboBox comboBox,comboBox1,comboBox2,comboBox3;
	JTextField field,field2,field3;
	JRadioButton r1,r2,r3,r4;
    Sinup2(String num){
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
    	JLabel l1=new JLabel("Page No : 2");
    	l1.setFont(new Font("Raleway",Font.BOLD, 20));
    	l1.setBounds(310, 30, 150, 30);
    	add(l1);
    	JLabel l2=new JLabel("Additonal Details");
    	l2.setFont(new Font("Raleway",Font.BOLD, 20));
    	l2.setBounds(290, 55, 200, 30);
    	add(l2);
    	JLabel l3=new JLabel("Religion          :");
    	l3.setFont(new Font("Raleway",Font.BOLD, 18));
    	l3.setBounds(100, 120, 150, 30);
    	add(l3);
    	String [] religion= {"Hindu","Muslim","Sikh","Christion","Others"};
    	comboBox=new JComboBox(religion);
    	comboBox.setFont(new Font("Raleway",Font.BOLD,14));
       	comboBox.setBounds(320, 120, 320, 30);
    	add(comboBox);
    	JLabel l4=new JLabel("Category         :");
    	l4.setFont(new Font("Raleway",Font.BOLD, 18));
    	l4.setBounds(100, 170, 160, 30);
    	add(l4);
    	String [] category= {"General","OBC","SC","ST","Others"};
    	comboBox1=new JComboBox(category);
    	comboBox1.setFont(new Font("Raleway",Font.BOLD,14));
    	comboBox1.setBounds(320, 170, 320, 30);
    	add(comboBox1);
    	JLabel l5=new JLabel("Income            :");
    	l5.setFont(new Font("Raleway",Font.BOLD, 18));
    	l5.setBounds(100, 220, 160, 30);
    	add(l5);
    	 field=new JTextField();
    	field.setFont(new Font("Raleway",Font.BOLD,14));
    	field.setBounds(320, 220, 320, 30);
    	add(field);
    	JLabel l6=new JLabel("Education       :");
    	l6.setFont(new Font("Raleway",Font.BOLD, 18));
    	l6.setBounds(100, 270, 160, 30);
    	add(l6);
    	String [] ed= {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
    	comboBox2=new JComboBox(ed);
    	comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
    	comboBox2.setBounds(320, 270, 320, 30);
    	add(comboBox2);
    	JLabel l7=new JLabel("Occupation     :");
    	l7.setFont(new Font("Raleway",Font.BOLD, 18));
    	l7.setBounds(100, 320, 150, 30);
    	add(l7);
    	String [] oc= {"Salaried","self-Employed","Business","Student","Retired","Others"};
    	comboBox3=new JComboBox(oc);
    	comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
    	comboBox3.setBounds(320, 320, 320, 30);
    	add(comboBox3);
    	JLabel l8=new JLabel("PAN Number   :");
    	l8.setFont(new Font("Raleway",Font.BOLD, 18));
    	l8.setBounds(100, 370, 150, 30);
    	add(l8);
    	 field2=new JTextField();
    	field2.setFont(new Font("Raleway",Font.BOLD,14));
    	field2.setBounds(320, 370, 320, 30);
    	add(field2);
    	JLabel l9=new JLabel("Aadhar Number   :");
    	l9.setFont(new Font("Raleway",Font.BOLD, 18));
    	l9.setBounds(80, 420, 180, 30);
    	add(l9);
    	 field3=new JTextField();
    	field3.setFont(new Font("Raleway",Font.BOLD,14));
    	field3.setBounds(320, 420, 320, 30);
    	add(field3);
    	JLabel l10=new JLabel("Senior Citizen   :");
    	l10.setFont(new Font("Raleway",Font.BOLD, 18));
    	l10.setBounds(80, 470, 180, 30);
    	add(l10);
    	r1=new JRadioButton("Yes");
    	r1.setFont(new Font("Raleway",Font.BOLD, 14));
    	r1.setBackground(new Color(252,208,76));
    	r1.setBounds(350, 470, 100, 30);
    	add(r1);
    	r2=new JRadioButton("No");
    	r2.setFont(new Font("Raleway",Font.BOLD, 14));
    	r2.setBackground(new Color(252,208,76));
    	r2.setBounds(490, 470, 100, 30);
    	add(r2);
    	ButtonGroup buttonGroup=new ButtonGroup();
    	buttonGroup.add(r1);
    	buttonGroup.add(r2);
    	JLabel l11=new JLabel("Existing Account   :");
    	l11.setFont(new Font("Raleway",Font.BOLD, 18));
    	l11.setBounds(60, 520, 180, 30);
    	add(l11);
    	r3=new JRadioButton("Yes");
    	r3.setFont(new Font("Raleway",Font.BOLD, 14));
    	r3.setBackground(new Color(252,208,76));
    	r3.setBounds(350, 520, 100, 30);
    	add(r3);
    	r4=new JRadioButton("No");
    	r4.setFont(new Font("Raleway",Font.BOLD, 14));
    	r4.setBackground(new Color(252,208,76));
    	r4.setBounds(490, 520, 100, 30);
    	add(r4);
    	ButtonGroup buttonGroup1=new ButtonGroup();
    	buttonGroup1.add(r3);
    	buttonGroup1.add(r4);
    	
    	next=new JButton("Next");
    	next.setFont(new Font("Raleway",Font.BOLD, 14));
    	next.setBackground(Color.BLACK);
    	next.setForeground(Color.WHITE);
    	next.setBounds(570, 640, 100, 30);
    	next.addActionListener(this);
    	add(next);
    	
    	 getContentPane().setBackground(new Color(252,208,76));
  	   setLayout(null);
  	   setSize(750, 730);
  	   setLocation(100, 0);
  	   setResizable(false);
  	   setVisible(true);
    }
   
	public void actionPerformed(ActionEvent e) {
		AdditonalDetails details=new AdditonalDetails();
		details.setFormNo(num);
		details.setReligion((String)comboBox.getSelectedItem());
		details.setCategory((String) comboBox1.getSelectedItem());
		details.setIncome(field.getText());
		details.setEducation((String)comboBox2.getSelectedItem());
		details.setOccupation((String)comboBox3.getSelectedItem());
	     details.setPanNumber(field2.getText());
	     details.setAadharNumber(field3.getText());
	     if(r1.isSelected()) {
				details.setSeniorCitizen("Yes");
			}else if(r2.isSelected()) {
				details.setSeniorCitizen("No");
			}
			if(r3.isSelected()) {
				details.setExistingAccount("Yes");
			}else if(r4.isSelected()) {
				details.setExistingAccount("No");
			}
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("saketh");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			if(details.getFormNo().equals("")||details.getReligion().equals("")||details.getCategory().equals("")) {
				JOptionPane.showMessageDialog(next, "fill form correctly");
			}else {
				et.begin();
				em.persist(details);
				et.commit();
				new Sinup3(num);
				setVisible(false);
			}
		
	}
	 public static void main(String[] args) {
			new Sinup2("");
		}
}
