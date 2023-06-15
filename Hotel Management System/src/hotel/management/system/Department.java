package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
       setBounds(400,200,700,480);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       
       JLabel l1=new JLabel("DEPARTMENT");
       l1.setBounds(180,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("BUDGET");
       l2.setBounds(370,10,100,20);
       add(l2);
       table=new JTable();
       table.setBounds(0, 50, 700, 350);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from department");
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
        new Department();
    }
}
