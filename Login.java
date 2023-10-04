/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author INSH
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
      setTitle("Bank Management System");
      setLayout(null);
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
      Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel label =new JLabel(i3);
      label.setBounds(70,10,100,100);
      add(label);
      
      JLabel text= new JLabel("Welcont to ATM");
      text.setBounds(200,40,400,40);
      text.setFont(new Font ("Osward",Font.BOLD,38));
      add(text);
      
      JLabel cardno= new JLabel("Card NO");
      cardno.setBounds(120,150,400,40);
      cardno.setFont(new Font ("Raleway",Font.BOLD,28));
      add(cardno);
      
      cardTextField =new JTextField();
      cardTextField.setBounds(300,150,230,30);
      cardTextField.setFont(new Font("Arial",Font.BOLD,14 ));
      add(cardTextField);
      
      
      JLabel pin =new JLabel("Pin");
      pin.setFont(new Font("Raleway" ,Font.BOLD,28));
      pin.setBounds(120,220,150,40);
      add(pin);
      
      pinTextField =new JPasswordField();
      pinTextField.setBounds(300,220,230,30);
      pinTextField.setFont(new Font("Arial",Font.BOLD,14 ));
      add(pinTextField);
      
      login =new JButton("SIGN IN");
      login.setBounds(300,280,100,30);
      login.setBackground(Color.BLACK);
      login.setForeground(Color.white.WHITE);
      login.addActionListener(this);
      add(login);
      
      clear=new JButton("Clear");
      clear.setBounds(430,280,100,30);
      clear.setBackground(Color.BLACK);
      clear.setForeground(Color.WHITE);
      clear.addActionListener(this);
      add(clear);
      
      signUp=new JButton("SIGN UP");
      signUp.setBounds(300,330,230,30);
      signUp.setBackground(Color.BLACK);
      signUp.setForeground(Color.WHITE);
      signUp.addActionListener(this);
      add(signUp);
      
      getContentPane().setBackground(Color.WHITE);
      setSize(800,480);
      setVisible(true);
      setLocation(350,200);
      
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==login){
                Conn c1 = new Conn();
                String cardnumber  = cardTextField.getText();
                String pinnumber  = pinTextField.getText();
                String q  = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource()==signUp){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String args[]){
        new Login().setVisible(true);
    }
}
