package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class AllEmployee extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    AllEmployee(){
       setBounds(400,200,700,480);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       
       
       JLabel l1=new JLabel("NAME");
       l1.setBounds(10,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("AGE");
       l2.setBounds(120,10,100,20);
       add(l2);
       
       JLabel l3=new JLabel("SALARY");
       l3.setBounds(230,10,100,20);
       add(l3);
       
       JLabel l4=new JLabel("PHONE");
       l4.setBounds(340,10,100,20);
       add(l4);

       JLabel l5=new JLabel("EMAIL");
       l5.setBounds(450,10,100,20);
       add(l5);
       
       JLabel l6=new JLabel("GENDER");
       l6.setBounds(520,10,100,20);
       add(l6);
       
       JLabel l7=new JLabel("JOB");
       l7.setBounds(620,10,100,20);
       add(l7);
       


       
       table=new JTable();
       table.setBounds(0, 50, 700, 350);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from employee");
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
        new AllEmployee();
    }
}
