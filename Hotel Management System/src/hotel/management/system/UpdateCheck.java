
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener {
    Choice cust;
    TextField tfroom,tfname,tfcheckin,tfamtp,tfpending;
    JButton check,update,back;
    UpdateCheck(){
        setBounds(300,200,980,500);
        setLayout(null);
        
        JLabel text=new JLabel("UPDATE STATUS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(90,20,200,30);
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
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
         tfroom=new TextField();
         tfroom.setBounds(200,120,150,25);
         add(tfroom);
         
         JLabel lblname=new JLabel("NAME");
        lblname.setBounds(30,160,100,20);
        add(lblname);
         tfname=new TextField();
         tfname.setBounds(200,160,150,25);
         add(tfname);
         
          JLabel lblcheckin=new JLabel("CHECKIN");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);
         tfcheckin=new TextField();
         tfcheckin.setBounds(200,200,150,25);
         add(tfcheckin);
         
          JLabel lblamtp=new JLabel("AMOUNT PAID");
        lblamtp.setBounds(30,240,100,20);
        add(lblamtp);
         tfpending=new TextField();
         tfpending.setBounds(200,280,150,25);
         add(tfpending);
         
         JLabel lblpending=new JLabel("AMT PENDING");
        lblpending.setBounds(30,280,100,20);
        add(lblpending);
         tfamtp=new TextField();
         tfamtp.setBounds(200,240,150,25);
         add(tfamtp);

         check=new JButton("CHECK");
         check.setBounds(30, 340, 100, 30);
         check.addActionListener(this);
         add(check);
         
         
          update=new JButton("UPDATE");
         update.setBounds(150, 340, 100, 30);
         update.addActionListener(this);
         add(update);
         
          back=new JButton("BACK");
         back.setBounds(270, 340, 100, 30);
         back.addActionListener(this);
         add(back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
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
                 tfname.setText(rs.getString("Name"));
                 tfcheckin.setText(rs.getString("Time"));
                 tfamtp.setText(rs.getString("Deposit"));
             }
             
             ResultSet rs2=c.s.executeQuery("select * from room where room='"+tfroom.getText()+"'");
             while(rs2.next()){
                 String price=rs2.getString("price");
                 int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfamtp.getText());
                 tfpending.setText(""+amountpaid);
             }
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
        }else if(ae.getActionCommand().equals("UPDATE")){
            String number=cust.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfroom.getText();
            String deposit=tfamtp.getText();
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room='"+room+"',Name='"+name+"',Time='"+checkin+"',Deposit='"+deposit+"' where number='"+number+"'");
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
        new UpdateCheck();
    }
}
