
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid,combogen;
    JTextField num,name,country,deposit;
    JLabel time;
    Choice croom;
    JButton add,back;
     AddCustomer(){
        setBounds(350,200,800,500);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setForeground(Color.WHITE);
        lblid.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblid);
        
        String str[]={"AADHARCARD","PASSPORT","PANCARD","DRIVING LISCENCE"};
        comboid=new JComboBox(str);
        comboid.setBounds(200, 80, 150, 25);
        add(comboid);
        
        JLabel lblnum=new JLabel("NUMBER");
        lblnum.setBounds(35,120,100,20);
        lblnum.setForeground(Color.WHITE);
        lblnum.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblnum);
        
        num=new JTextField();
        num.setBounds(200, 120, 150, 25);
        add(num);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(35,160,100,20);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblname);
        
        name=new JTextField();
        name.setBounds(200, 160, 150, 25);
        add(name);
        
         JLabel lblgen=new JLabel("GENDER");
        lblgen.setBounds(35,200,100,20);
        lblgen.setForeground(Color.WHITE);
        lblgen.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblgen);
        
         String gender[]={"MALE","FEMALE"};
        combogen=new JComboBox(gender);
        combogen.setBounds(200, 200, 150, 25);
        add(combogen);
        
        JLabel lblcoun=new JLabel("COUNTRY");
        lblcoun.setBounds(35,240,100,20);
        lblcoun.setForeground(Color.WHITE);
        lblcoun.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblcoun);
        
        country=new JTextField();
        country.setBounds(200, 240, 150, 25);
        add(country);
        
        JLabel lblroom=new JLabel("ROOM NUMBER");
        lblroom.setBounds(35,280,150,20);
        lblroom.setForeground(Color.WHITE);
        lblroom.setFont(new Font("Raleway",Font.BOLD,18));
        add(lblroom);
        
        
        croom=new Choice();
       try {
            Conn conn=new Conn();
            String query="select * from addroom";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("room"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbltime=new JLabel("CHECKIN TIME");
        lbltime.setBounds(35,320,150,20);
        lbltime.setForeground(Color.WHITE);
        lbltime.setFont(new Font("Raleway",Font.BOLD,20));
        add(lbltime);
        
        Date date=new Date();
        time=new JLabel(""+ date);
        time.setBounds(200,320,150,25);
        time.setForeground(Color.BLACK);
        time.setFont(new Font("Raleway",Font.PLAIN,16));
        add(time);
        
         JLabel lbldeposit=new JLabel("DEPOSIT");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setForeground(Color.WHITE);
        lbldeposit.setFont(new Font("Raleway",Font.BOLD,20));
        add(lbldeposit);
        
        add=new JButton("ADD");
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        add.setForeground(Color.BLACK);
        add.setBounds(50,410,120,25);
        add(add);
        deposit=new JTextField();
        deposit.setBounds(200, 360, 150, 25);
        add(deposit);
        
        back=new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setForeground(Color.BLACK);
        back.setBounds(200,410,120,25);
        add(back);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
         Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        




        
        getContentPane().setBackground(Color.MAGENTA);
        setVisible(true);
    }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== add){
             String id=(String)comboid.getSelectedItem();
             String number=num.getText();
             String Name= name.getText();
             String gender=(String)combogen.getSelectedItem();
             String Country=country.getText();
             String room=croom.getSelectedItem(); 
             String Time=time.getText();
             String Deposit=deposit.getText();
             try{
                 Conn conn=new Conn();
                  String query1 = "insert into customer values('"+id+"','"+number+"','"+Name+"','"+gender+"','"+Country+"','"+room+"','"+Time+"','"+Deposit+"')";
                  String query2="update room set available='available' where room='"+room+"'";
                  conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);
                  JOptionPane.showMessageDialog(null, "Customer added Successfully");
            setVisible(false);
            new Reception();
             }  catch(Exception e){
                 e.printStackTrace();
             }
             
         }else if (ae.getSource()== back){
         setVisible(false);
            new Reception();
     }
     }
     public static void main(String[] args){
         new AddCustomer();
     }
}
