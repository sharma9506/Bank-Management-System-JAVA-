/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
         setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
      
        back =new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBounds(355, 510, 150, 30);
        back.addActionListener(this);
        add(back);
        int balance =0;
        Conn c=new Conn();
         try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'"); 
            while(rs.next()){
                  if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                  
             }
              
            }catch(Exception e){
                System.out.println(e);
           }
        
        JLabel text = new JLabel("<html>Your current account balance is <br> Rs. " + balance + "</html>");
        text.setBounds(165,340,700,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,20));
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
    
}
