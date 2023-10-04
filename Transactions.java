/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text =new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);
        
        deposit =new JButton("Deposit");
        deposit.setFont(new Font("Arial",Font.BOLD,14));
        deposit.setBounds(170, 415, 160, 30);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl =new JButton("Withdrawl");
        withdrawl.setFont(new Font("Arial",Font.BOLD,14));
        withdrawl.setBounds(345, 415, 160, 30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastcash =new JButton("Fast Cash");
        fastcash.setFont(new Font("Arial",Font.BOLD,14));
        fastcash.setBounds(170, 450, 160, 30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement =new JButton("Mini Statement");
        ministatement.setFont(new Font("Arial",Font.BOLD,14));
        ministatement.setBounds(345, 450, 160, 30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange =new JButton("Pin Change");
        pinchange.setFont(new Font("Arial",Font.BOLD,14));
        pinchange.setBounds(170, 485, 160, 30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenquiry =new JButton("Balance Enquiry");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
           setVisible(false);
           new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}
