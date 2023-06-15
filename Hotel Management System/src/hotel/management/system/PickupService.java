package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class PickupService extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    PickupService(){
       setBounds(300,200,1050,600);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       JLabel text=new JLabel("PICKUP SERVICE");
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       text.setBounds(400,30,200,30);
       add(text);
       
       JLabel lblbed=new JLabel("TYPE OF CAR");
       lblbed.setBounds(50, 100, 100, 20);
       add(lblbed);
       
       typeofcar=new Choice();
       typeofcar.setBounds(150, 100, 200, 25);
       add(typeofcar);
       
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from driver");
           while(rs.next()){
               typeofcar.add(rs.getString("carmodel"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       
       
       JLabel l1=new JLabel("NAME");
       l1.setBounds(10,170,100,20);
       add(l1);
       
       JLabel l2=new JLabel("AGE");
       l2.setBounds(150,170,100,20);
       add(l2);
       
       JLabel l3=new JLabel("GENDER");
       l3.setBounds(290,170,100,20);
       add(l3);
       
       JLabel l4=new JLabel("CARCOMPANY");
       l4.setBounds(430,170,100,20);
       add(l4);
       
       JLabel l5=new JLabel("CARMODEL");
       l5.setBounds(570,170,100,20);
       add(l5);
       
       JLabel l6=new JLabel("AVAILABLE");
       l6.setBounds(710,170,100,20);
       add(l6);
       
       JLabel l7=new JLabel("LOCATION");
       l7.setBounds(850,170,100,20);
       add(l7);

       

       


       
       table=new JTable();
       table.setBounds(0, 200, 1000, 300);
       add(table);
       
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from driver");
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("BACK");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.setBounds(500,520,120,30);
       back.addActionListener(this);
       add(back);
       
       submit=new JButton("SUBMIT");
       submit.setBackground(Color.WHITE);
       submit.setForeground(Color.BLACK);
       submit.setBounds(300,520,120,30);
       submit.addActionListener(this);
       add(submit);
       
               
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
            
                String query1="select * from driver where carmodel='"+typeofcar.getSelectedItem()+"'";
                 Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery(query1); 
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }       else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new PickupService();
    }
}


