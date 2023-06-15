
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDrivers extends JFrame implements ActionListener{
    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JComboBox cleans,avail;
    JButton add,cancel;
    
     AddDrivers(){
         setBounds(300,200,980,470);
         setLayout(null);
         JLabel heading=new JLabel("ADD DRIVERS");
         heading.setFont(new Font("tahoma",Font.BOLD,18));
         heading.setForeground(Color.white);
         heading.setBounds(200,20,200,20);
         add(heading);
         
         JLabel lblname=new JLabel("NAME");
         lblname.setFont(new Font("tahoma",Font.PLAIN,16));
         lblname.setForeground(Color.white);
         lblname.setBounds(60,80,120,20);
         add(lblname);
         
         tfname=new JTextField();
           tfname.setBounds(200,80,150,30);
           add(tfname);
           
           JLabel lblage=new JLabel("AGE");
         lblage.setFont(new Font("tahoma",Font.PLAIN,16));
         lblage.setForeground(Color.white);
         lblage.setBounds(60,130,120,30);
         add(lblage);
          
         tfage=new JTextField();
           tfage.setBounds(200,130,150,30);
           add(tfage);
        
         JLabel lblgender=new JLabel("GENDER");
        lblgender.setFont(new Font("tahoma",Font.PLAIN,16));
         lblgender.setForeground(Color.white);
         lblgender.setBounds(60,180,120,30);
         add(lblgender);
         
          String gen[]={"MALE","FEMALE"};
         cleans=new JComboBox(gen);
        cleans.setBounds(200,180,150,30);
        add(cleans);
        
        JLabel lblcarcompany=new JLabel("CAR COMPANY");
         lblcarcompany.setFont(new Font("tahoma",Font.PLAIN,16));
         lblcarcompany.setForeground(Color.white);
         lblcarcompany.setBounds(60,230,120,30);
         add(lblcarcompany);
         
         tfcompany=new JTextField();
           tfcompany.setBounds(200,230,150,30);
           add(tfcompany);
           
           JLabel lblcarmodel=new JLabel("CAR MODEL");
        lblcarmodel.setFont(new Font("tahoma",Font.PLAIN,16));
         lblcarmodel.setForeground(Color.white);
         lblcarmodel.setBounds(60,280,120,30);
         add(lblcarmodel);
         
          tfmodel=new JTextField();
           tfmodel.setBounds(200,280,150,30);
           add(tfmodel);
           
           JLabel lblavailable=new JLabel("AVAILABLE");
        lblavailable.setFont(new Font("tahoma",Font.PLAIN,16));
         lblavailable.setForeground(Color.white);
         lblavailable.setBounds(60,330,120,30);
         add(lblavailable);
         
          String ava[]={"yes","no"};
         avail=new JComboBox(ava);
        avail.setBounds(200,330,150,30);
        add(avail);
        
        JLabel lbllocation=new JLabel("LOCATION");
        lbllocation.setFont(new Font("tahoma",Font.PLAIN,16));
         lbllocation.setForeground(Color.white);
         lbllocation.setBounds(60,380,120,30);
         add(lbllocation);
         
         tflocation=new JTextField();
           tflocation.setBounds(200,380,150,30);
           add(tflocation);
         
         add=new JButton("ADD DRIVER");
         add.setForeground(Color.BLACK);
         add.setBackground(Color.WHITE);
         add.addActionListener(this);
         add.setBounds(500,380,130,30);
         add(add);
         
          cancel=new JButton("CANCEL");
         cancel.setForeground(Color.BLACK);
         cancel.setBackground(Color.WHITE);
         cancel.setBounds(700,380,130,30);
         cancel.addActionListener(this);
         add(cancel);
         
         ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(400,30,500,300);
         add(image);   
         getContentPane().setBackground(Color.MAGENTA);
            setVisible(true);
     }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)cleans.getSelectedItem();
            String carcompany=tfcompany.getText();
            String carmodel=tfmodel.getText();
             String available=(String)avail.getSelectedItem();
             String location=tflocation.getText();
             
            
         try{
             Conn conn=new Conn();
             String hello = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+available+"','"+location+"')";
             conn.s.executeUpdate(hello);
            JOptionPane.showMessageDialog(null, "Driver added Successfully");
            setVisible(false);
         }catch(Exception e){
        e.printStackTrace();
    }
        }else{
            setVisible(false);
        }
    }
        
    public static void main(String[] args){
         new AddDrivers();
     }
}