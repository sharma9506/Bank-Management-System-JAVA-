/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author INSH
 */
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class SignupOne extends  JFrame implements ActionListener{
    long random;
    JTextField nameTextField ,fnameTextField,cityTextField,pinTextField ,stateTextField ,maritalTextField, addressTextField ,emailTextField;
    JDateChooser  dateChooser;
    JRadioButton male,female,single,married,others;
    JButton next;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random =Math.abs(ran.nextLong() %9000L)+1000L;
        
     
        JLabel formno =new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails =new JLabel("Page-1: Personal Details");
        personDetails .setFont(new Font("Raleway",Font.BOLD,25));
        personDetails .setBounds(290,80,400,30);
        add(personDetails );
        
        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Arial" , Font.BOLD,28));
        name.setBounds(150,130,200,50);
        add(name);
        
        nameTextField =new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,14));
        nameTextField.setBounds(370, 140, 330, 30);
        add(nameTextField);
        
        
        
        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Arial", Font.BOLD,28));
        fname.setBounds(150,180,220,50);
        add(fname);
        
        fnameTextField =new JTextField();
        fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
        fnameTextField.setBounds(370, 190, 330, 30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("DOB : ");
        dob.setFont(new Font("Arial", Font.BOLD,28));
        dob.setBounds(150,230,200,50);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(370,240,330,30);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setFont(new Font("Arial",Font.BOLD,14));
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Arial", Font.BOLD,28));
        gender.setBounds(150,280,200,50);
        add(gender);
        
        male =new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.BOLD,18));
        male.setBounds(370,290,120,30);
        male.setBackground(Color.GRAY);
        add(male);
        female =new JRadioButton("Female");
        female.setFont(new Font("Arial",Font.BOLD,18));
        female.setBounds(500,290,120,30);
        female.setBackground(Color.GRAY);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email : ");
        email.setFont(new Font("Arial", Font.BOLD,28));
        email.setBounds(150,330,200,50);
        add(email);
        emailTextField =new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        emailTextField.setBounds(370, 340, 330, 30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status : ");
        marital.setFont(new Font("Arial", Font.BOLD,28));
        marital.setBounds(150,380,220,50);
        add(marital);
        
        single =new JRadioButton("Single");
        single.setFont(new Font("Arial",Font.BOLD,18));
        single.setBounds(370,390,120,30);
        single.setBackground(Color.GRAY);
        add(single);
        
        married =new JRadioButton("Married");
        married.setFont(new Font("Arial",Font.BOLD,18));
        married.setBounds(500,390,120,30);
        married.setBackground(Color.GRAY);
        add(married);
        others =new JRadioButton("Other");
        others.setFont(new Font("Arial",Font.BOLD,18));
        others.setBounds(620,390,120,30);
        others.setBackground(Color.GRAY);
        add(others);
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        maritalgroup.add(others);
        
        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Arial", Font.BOLD,28));
        address.setBounds(150,430,200,50);
        add(address);
        
        addressTextField =new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        addressTextField.setBounds(370, 430, 330, 30);
        add(addressTextField);
        
        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Arial", Font.BOLD,28));
        city.setBounds(150,480,200,50);
        add(city);
        
        cityTextField =new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        cityTextField.setBounds(370, 480, 330, 30);
        add(cityTextField);
        
        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Arial", Font.BOLD,28));
        state.setBounds(150,530,200,50);
        add(state);
        
        stateTextField =new JTextField();
        stateTextField.setFont(new Font("Arial",Font.BOLD,14));
        stateTextField.setBounds(370, 530, 330, 30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pin Code : ");
        pincode.setFont(new Font("Arial", Font.BOLD,28));
        pincode.setBounds(150,580,200,50);
        add(pincode);
        
        pinTextField =new JTextField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setBounds(370, 580, 330, 30);
        add(pinTextField);
        
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setBounds(580,650,120,40);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.GRAY);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public  void actionPerformed(ActionEvent ae){
        String formno= " "+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }else if(female.isSelected()){
            gender="female";
        }
        
        String email=emailTextField.getText();
         
        String marital=null;
        if(single.isSelected()){
            marital="Single";
        }else if(married.isSelected()){
           marital="Married";
        }else if(others.isSelected()){
            marital="Other";
        }
        
         String address=addressTextField.getText();
         String city=cityTextField.getText();
         String state=stateTextField.getText();
         String pin=pinTextField.getText();
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null, "Name is required");
             }else{
                 Conn c =new Conn();
                 String query ="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             }
         }catch(Exception e){
             System.out.println(e);
         }
         
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
