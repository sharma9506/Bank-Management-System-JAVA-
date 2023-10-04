/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page-3: Account Details");
        l1.setFont(new Font("Arial",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type : ");
        type.setFont(new Font("Arial" , Font.BOLD,28));
        type.setBounds(110,120,250,50);
        add(type);
        
        r1 =new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial",Font.BOLD,18));
        r1.setBounds(100,180,230,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 =new JRadioButton("Current Account");
        r2.setFont(new Font("Arial",Font.BOLD,18));
        r2.setBounds(350,180,270,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        r3 =new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Arial",Font.BOLD,18));
        r3.setBounds(100,230,230,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        r4 =new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Arial",Font.BOLD,18));
        r4.setBounds(350,230,270,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup accountType=new ButtonGroup();
        accountType.add(r1);
        accountType.add(r2);
        accountType.add(r3);
        accountType.add(r4);
        
        JLabel card=new JLabel(" Card Number :");
        card.setFont(new Font("Arial", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel carddetail=new JLabel("16 digits number");
        carddetail.setFont(new Font("Arial", Font.BOLD,12));
        carddetail.setBounds(105,320,200,30);
        add(carddetail);
        
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1648");
        number.setFont(new Font("Arial", Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Arial", Font.BOLD,22));
        pin.setBounds(105,370,200,30);
        add(pin);
        JLabel pnum=new JLabel("4 digits pin");
        pnum.setFont(new Font("Arial", Font.BOLD,12));
        pnum.setBounds(105,390,200,30);
        add(pnum);
        
        
        JLabel pNumber=new JLabel("XXXX");
        pNumber.setFont(new Font("Arial", Font.BOLD,22));
        pNumber.setBounds(330,370,200,30);
        add(pNumber);
        
        JLabel service=new JLabel("Service Required ");
        service.setFont(new Font("Arial", Font.BOLD,22));
        service.setBounds(100,450,200,30);
        add(service);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(100,540,200,30);
        add(c2);
        
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,580,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setBounds(330,500,200,30);
        add(c4);
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(330,540,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setBounds(330,580,200,30);
        add(c6);
        
        c7=new JCheckBox("I here declares that the above entered details are correct to best of my Knowledge");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,650,500,20);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial",Font.BOLD,14));
        submit.setBounds(150,700,150,40);
        submit.addActionListener(this);
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial",Font.BOLD,14));
        cancel.setBounds(400,700,150,40);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.GRAY);
        setSize(820,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
            if(r1.isSelected()){
                accountType="Saving Account";
            }
            else if(r2.isSelected()){
                accountType="Current Account";
            }
            else if(r3.isSelected()){
                accountType="Fixed Deposit Account";
            }
            else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
          Random random=new Random();
          String cardnumber= "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
          
          String pinnumber= ""+ Math.abs((random.nextLong() % 9000L)+1000L);
          
          String facility ="";
          if(c1.isSelected()){
              facility = facility +"ATM CARD";
          }
           if(c2.isSelected()){
              facility = facility +" Internet Banking";
          }
           if(c3.isSelected()){
              facility = facility +" Mobile Banking";
          }
          if(c4.isSelected()){
              facility = facility +" Email & SMS Alerts";
          }
          if(c5.isSelected()){
              facility = facility +" Check Book";
          }
          if(c6.isSelected()){
              facility = facility +" E-statement";
          }
          try{
              if(accountType.equals("")){
                 JOptionPane.showMessageDialog(null, "Fill all the required fields");     
              }else {
                  Conn conn=new Conn();
                  String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                  String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";  
                  conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);
                 JOptionPane.showMessageDialog(null ,"Card Number :"+cardnumber+"\nPin : "+pinnumber);
                 setVisible(false);
                 new Deposit(pinnumber).setVisible(false);
              } 
                  
          }catch(Exception e){
              System.out.println(e);
          }
          
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
