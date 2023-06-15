
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Rooms(){
       setBounds(300,200,1050,600);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
       Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(500,0,600,600);
       add(image);
       
       JLabel l1=new JLabel("ROOM NUMBER");
       l1.setBounds(10,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("AVAILABLE");
       l2.setBounds(120,10,100,20);
       add(l2);
       
       JLabel l3=new JLabel("STATUS");
       l3.setBounds(230,10,100,20);
       add(l3);
       
       JLabel l4=new JLabel("PRICE");
       l4.setBounds(330,10,100,20);
       add(l4);

       


       
       table=new JTable();
       table.setBounds(0, 40, 500, 400);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from addroom");
           table.setModel(DbUtils.resultSetToTableModel(rs));
               
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("BACK");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.setBounds(200,500,120,30);
       back.addActionListener(this);
       add(back);
       
               
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
                
    }
    public static void main(String[] args){
        new Rooms();
    }
}
