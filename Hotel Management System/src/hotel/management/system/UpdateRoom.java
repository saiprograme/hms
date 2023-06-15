package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener {
    Choice cust;
    TextField tfroom,tfavail,tfclean,tfamtp,tfpending;
    JButton check,update,back;
    UpdateRoom(){
        setBounds(300,200,980,450);
        setLayout(null);
        
        JLabel text=new JLabel("UPDATE ROOM");
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setBounds(30,20,250,30);
        add(text);
        
        cust=new Choice();
        cust.setBounds(200, 80, 150, 25);
        add(cust);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cust.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
         JLabel lblroom=new JLabel("ROOM");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
         tfroom=new TextField();
         tfroom.setBounds(200,130,150,25);
         add(tfroom);
         
         JLabel lblavail=new JLabel("AVAILABILITY");
        lblavail.setBounds(30,180,100,20);
        add(lblavail);
         tfavail=new TextField();
         tfavail.setBounds(200,180,150,25);
         add(tfavail);
         
          JLabel lblclean=new JLabel("CLEANING STATUS");
        lblclean.setBounds(30,230,100,20);
        add(lblclean);
         tfclean=new TextField();
         tfclean.setBounds(200,230,150,25);
         add(tfclean);
         

         check=new JButton("CHECK");
         check.setBounds(30, 300, 100, 30);
         check.addActionListener(this);
         add(check);
         
         
          update=new JButton("UPDATE");
         update.setBounds(150, 300, 100, 30);
         update.addActionListener(this);
         add(update);
         
          back=new JButton("BACK");
         back.setBounds(270, 300, 100, 30);
         back.addActionListener(this);
         add(back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
         JLabel image=new JLabel(i1);
         image.setBounds(400,50,500,300);
         add(image);



         
        getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("CHECK")){
        String id=cust.getSelectedItem();
        String q="select * from customer where number='"+id+"'";
        try{
            Conn c=new Conn();
             ResultSet rs=c.s.executeQuery(q);
             while(rs.next()){
                 tfroom.setText(rs.getString("room"));
             }
             
             ResultSet rs2=c.s.executeQuery("select * from room where room='"+tfroom.getText()+"'");
             while(rs2.next()){
                tfavail.setText(rs2.getString("available"));
                tfclean.setText(rs2.getString("status"));
                
             }
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
        }else if(ae.getActionCommand().equals("UPDATE")){
            String number=cust.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavail.getText();
            String status=tfclean.getText();            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set available='"+available+"',status='"+status+"' where room='"+room+"'");
                JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY");
                setVisible(false);
                new Reception(); 
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new UpdateRoom();
    }
}

