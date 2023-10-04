/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class SignupTwo extends  JFrame implements ActionListener{
    
    String formno;
    JTextField aadhar, pan ;
    JComboBox religion,category,occupation,education,income;
    JRadioButton sYes,sNo,eYes,eNo;
    JButton next;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");
     
       
        
        JLabel addtionalDetails =new JLabel("Page-2 : Additional Details");
        addtionalDetails .setFont(new Font("Raleway",Font.BOLD,25));
        addtionalDetails .setBounds(290,80,400,30);
        add(addtionalDetails );
        
        JLabel name=new JLabel("Religion : ");
        name.setFont(new Font("Arial" , Font.BOLD,28));
        name.setBounds(150,130,200,50);
        add(name);
        
        String[] valReligion ={"Hindu","Muslim", "Sikh","Christian","Others"};
        religion =new JComboBox(valReligion);
        religion.setBounds(370,140,330,30);
        add(religion);
        
  
        JLabel fname=new JLabel("Category : ");
        fname.setFont(new Font("Arial", Font.BOLD,28));
        fname.setBounds(150,180,220,50);
        add(fname);
        
        String[] valCategory ={"General","OBC", "ST","SC","Other"};
        category =new JComboBox(valCategory);
        category.setBounds(370,190,330,30);
        add(category);
        
        
        
        JLabel dob=new JLabel("income : ");
        dob.setFont(new Font("Arial", Font.BOLD,28));
        dob.setBounds(150,230,200,50);
        add(dob);
        String[] valSalary ={"income","0-1.5 Lacs", "1.5-2.5 Lacs","2.5-5.0 Lacs","Above 5 Lacs"};
        income =new JComboBox(valSalary);
        income.setBounds(370,240,330,30);
        add(income);
        
       
        
        JLabel gender=new JLabel("Education Or ");
        gender.setFont(new Font("Arial", Font.BOLD,28));
        gender.setBounds(150,280,200,50);
        add(gender);
        
       
        JLabel email=new JLabel("Qualificaiton : ");
        email.setFont(new Font("Arial", Font.BOLD,28));
        email.setBounds(150,310,200,50);
        add(email);
        
        String[] educationVal={"Non-Graduate","Graduate", "Post-Graduate","Doctorate","Others"};
        education =new JComboBox(educationVal);
        education.setBounds(370,310,330,30);
        add(education);
       
        JLabel marital=new JLabel("Occupation : ");
        marital.setFont(new Font("Arial", Font.BOLD,28));
        marital.setBounds(150,360,220,50);
        add(marital);
        
        String[] occupationVal={"Salaried","Self-Emplyed", "Student","Business","Others"};
        occupation =new JComboBox(occupationVal);
        occupation.setBounds(370,370,330,30);
        add(occupation);
        
        
        
        JLabel address=new JLabel("Pan No : ");
        address.setFont(new Font("Arial", Font.BOLD,28));
        address.setBounds(150,430,200,50);
        add(address);
        
        pan =new JTextField();
        pan.setFont(new Font("Arial",Font.BOLD,14));
        pan.setBounds(370, 430, 330, 30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar No : ");
        city.setFont(new Font("Arial", Font.BOLD,28));
        city.setBounds(150,480,200,50);
        add(city);
        
        aadhar =new JTextField();
        aadhar.setFont(new Font("Arial",Font.BOLD,14));
        aadhar.setBounds(370, 480, 330, 30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen : ");
        state.setFont(new Font("Arial", Font.BOLD,28));
        state.setBounds(150,530,220,50);
        add(state);
        
        sYes =new JRadioButton("YES");
        sYes.setFont(new Font("Arial",Font.BOLD,14));
        sYes.setBounds(370, 540, 100, 30);
        add(sYes);
        sNo =new JRadioButton("No");
        sNo.setFont(new Font("Arial",Font.BOLD,14));
        sNo.setBounds(500, 540, 100, 30);
        add(sNo);
        ButtonGroup maritalgroup =new ButtonGroup();
        maritalgroup.add(sYes);
        maritalgroup.add(sNo);
        
        JLabel pincode=new JLabel("Existing Ac :");
        pincode.setFont(new Font("Arial", Font.BOLD,28));
        pincode.setBounds(150,580,220,50);
        add(pincode);
        
        eYes =new JRadioButton("YES");
        eYes.setFont(new Font("Arial",Font.BOLD,14));
        eYes.setBounds(370, 580, 100, 30);
        add(eYes);
        eNo =new JRadioButton("No");
        eNo.setFont(new Font("Arial",Font.BOLD,14));
        eNo.setBounds(500, 580, 100, 30);
        add(eNo);
        ButtonGroup acountgroup =new ButtonGroup();
        acountgroup.add(eYes);
        acountgroup.add(eNo);
    
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
       
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String )category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        
        String seniorcitizen=null;
        if(sYes.isSelected()){
            seniorcitizen="Yes";
        }else if(sNo.isSelected()){
            seniorcitizen="No";
        }
        
                 
        String existingaccount=null;
        if(eYes.isSelected()){
            existingaccount="Yes";
        }else if(eNo.isSelected()){
           existingaccount="No";
        }
        
         String span=pan.getText();
         String saadhar=aadhar.getText();
         
         try{
                 Conn c =new Conn();
                 String query ="insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                 new SignupThree(formno).setVisible(true);
             
         }catch(Exception e){
             System.out.println(e);
         }
         
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
