/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin ,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text =new JLabel("CHANGE YOUR PIN");
        text.setBounds(220,300,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext =new JLabel("NEW PIN");
        pintext.setBounds(165,340,100,35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Arial",Font.BOLD,16));
        image.add(pintext);
        
        pin =new JPasswordField();
        pin.setFont(new Font("Arial",Font.BOLD,14));
        pin.setBounds(300, 345, 150, 25);
        add(pin);
        
        
        JLabel repintext =new JLabel("COMFIRM PIN");
        repintext.setBounds(165,380,700,35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Arial",Font.BOLD,16));
        image.add(repintext);
        
        repin =new JPasswordField();
        repin.setFont(new Font("Arial",Font.BOLD,14));
        repin.setBounds(300, 385, 150, 25);
        add(repin);
        
        change =new JButton("CHANGE");
        change.setFont(new Font("Arial",Font.BOLD,14));
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        add(change);
        
        back =new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
            
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
               return;
            }
             if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter new PIN");
               return;
            }
             if(rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
               return;
            }
             Conn c=new Conn();
             String query1 = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
             String query2 = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
             String query3 = "UPDATE signup3 SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             c.s.executeUpdate(query3);
             
            JOptionPane.showMessageDialog(null, "PIN changed Succesfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
       }
        
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
