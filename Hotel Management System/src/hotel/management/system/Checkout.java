package hotel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Checkout extends JFrame implements ActionListener{
    Choice cust;
    JLabel lblroomn,lblcheck,lblchecko;
    JButton checkout,back;
    Checkout(){
        setBounds(300,200,800,400);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        JLabel text=new JLabel("CHECKOUT");
        text.setBounds(100,20,100,30);
        text.setFont(new Font("Tahoma",Font.BOLD,15));
        add(text);
        
        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
         cust=new Choice();
        cust.setBounds(150, 80, 150, 25);
        add(cust);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cust.add(rs.getString("number"));
                lblroomn.setText(rs.getString("room"));
                lblcheck.setText(rs.getString("Time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
        

        JLabel lblroom=new JLabel("ROOM NUMBER");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
       lblroomn=new JLabel();
        lblroomn.setBounds(150, 130, 100, 30);
        add(lblroomn);
                
         JLabel lblcheckin=new JLabel("CHECKIN");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
       lblcheck=new JLabel();
        lblcheck.setBounds(150, 180, 100, 30);
        add(lblcheck);
                        
          JLabel lblcheckout=new JLabel("CHECKOUT");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date=new Date();
       lblchecko=new JLabel(""+date);
        lblchecko.setBounds(150, 230, 170, 30);
        add(lblchecko);
                       
         back=new JButton("BACK");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.setBounds(170,280,120,30);
       back.addActionListener(this);
       add(back);
       
       checkout=new JButton("CHECKOUT");
       checkout.setBackground(Color.WHITE);
       checkout.setForeground(Color.BLACK);
       checkout.setBounds(30,280,120,30);
       checkout.addActionListener(this);
       add(checkout);  
       
       try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cust.add(rs.getString("number"));
                lblroomn.setText(rs.getString("room"));
                lblcheck.setText(rs.getString("Time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(350,50,400,250);
        add(image1);
        
                
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query1="delete from customer where number='"+cust.getSelectedItem()+"'";
            String query2="update room set available='available' where room='"+lblroomn.getText()+"'";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"cheeckout done");
                setVisible(false);
            new Reception();

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    } 
    public static void main(String[] args){
        new Checkout();
    }
}
