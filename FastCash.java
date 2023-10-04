/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text =new JLabel("Please select withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);
        
        deposit =new JButton("Rs.100");
        deposit.setFont(new Font("Arial",Font.BOLD,14));
        deposit.setBounds(170, 415, 160, 30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl =new JButton("Rs.500");
        withdrawl.setFont(new Font("Arial",Font.BOLD,14));
        withdrawl.setBounds(345, 415, 160, 30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastcash =new JButton("Rs.1000");
        fastcash.setFont(new Font("Arial",Font.BOLD,14));
        fastcash.setBounds(170, 450, 160, 30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement =new JButton("Rs.2000");
        ministatement.setFont(new Font("Arial",Font.BOLD,14));
        ministatement.setBounds(345, 450, 160, 30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange =new JButton("Rs.5000");
        pinchange.setFont(new Font("Arial",Font.BOLD,14));
        pinchange.setBounds(170, 485, 160, 30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenquiry =new JButton("Rs.10000");
        balanceenquiry.setFont(new Font("Arial",Font.BOLD,14));
        balanceenquiry.setBounds(345, 485, 160, 30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exit =new JButton("Exit");
        exit.setFont(new Font("Arial",Font.BOLD,14));
        exit.setBounds(345, 520, 160, 30);
        exit.addActionListener(this);
        add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
             ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'"); 
             int balance =0;
           
             while(rs.next()){
                  if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                  
             }
              if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null,"Insuffient Balance");
                  return ;
              }
            
              Date date =new Date();
              String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs."+amount+ " Debited Successfully");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
             
              
            }catch(Exception e){
                System.out.println(e);
           }
        }
       
     }
     public static void main(String args[]){
        new FastCash("");
    }

}
