package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
       setBounds(400,200,700,480);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       
       
       JLabel l1=new JLabel("ID");
       l1.setBounds(10,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("NUMBER");
       l2.setBounds(90,10,100,20);
       add(l2);
       
       JLabel l3=new JLabel("NAME");
       l3.setBounds(170,10,100,20);
       add(l3);
       
       JLabel l4=new JLabel("GENDER");
       l4.setBounds(260,10,100,20);
       add(l4);

       JLabel l5=new JLabel("COUNTRY");
       l5.setBounds(350,10,100,20);
       add(l5);
       
       JLabel l6=new JLabel("ROOM");
       l6.setBounds(440,10,100,20);
       add(l6);
       
       JLabel l7=new JLabel("TIME");
       l7.setBounds(530,10,100,20);
       add(l7);
        JLabel l8=new JLabel("DEPOSIT");
       l8.setBounds(610,10,100,20);
       add(l8);
       


       
       table=new JTable();
       table.setBounds(0, 50, 700, 350);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from customer");
           table.setModel(DbUtils.resultSetToTableModel(rs));
               
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("BACK");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.setBounds(280,410,120,30);
       back.addActionListener(this);
       add(back);
       
               
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
                
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}


