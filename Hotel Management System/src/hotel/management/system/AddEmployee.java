
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfsalary,tfph,tfemail;
    JRadioButton jmale,jfemale;
    JButton submit;
    JComboBox box;
            
    AddEmployee(){
        setLayout(null);
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblname);
         tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setForeground(Color.WHITE);
        lblage.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblage);
         tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setForeground(Color.WHITE);
        lblgender.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblgender);
        
        jmale=new JRadioButton("MALE");
        jmale.setBounds(200, 130, 70, 30);
        jmale.setForeground(Color.white);
        jmale.setBackground(Color.magenta);
        jmale.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
        add(jmale);
        
         jfemale=new JRadioButton("FEMALE");
        jfemale.setBounds(280, 130, 70, 30);
        jfemale.setForeground(Color.white);
        jfemale.setBackground(Color.magenta);
        jfemale.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
        add(jfemale);
        ButtonGroup bg=new ButtonGroup();
        bg.add(jmale);
        bg.add(jfemale);
        
        
        
         JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setForeground(Color.WHITE);
        lbljob.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lbljob);
        
        String str[]={"MANGER","FRONT DESK CLERKS","PORTERS","HOUSEKEEPING","WAITER/WAITRESS","CHEF","KITCHENSTAFF"};
        box=new JComboBox(str);
        box.setBounds(200,180,150,30);
        add(box);
        
        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setForeground(Color.WHITE);
        lblsalary.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblsalary);
         tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
         JLabel lblph=new JLabel("PHONE");
        lblph.setBounds(60,280,120,30);
        lblph.setForeground(Color.WHITE);
        lblph.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblph);
        tfph=new JTextField();
        tfph.setBounds(200,280,150,30);
        add(tfph);
        
        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setForeground(Color.WHITE);
        lblemail.setFont(new Font("tahoma",Font.CENTER_BASELINE,17));
        add(lblemail);
         tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.white);
        submit.setForeground(Color.BLACK);
        submit.setBounds(200,400,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);


        
        getContentPane().setBackground(Color.magenta);
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfph.getText();
        String email=tfemail.getText();
        String gender=null;
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "name should not be empty");
        }
       
        if(jmale.isSelected()){
            gender="MALE";
        }else if(jfemale.isSelected()){
            gender="FEMALE";
        }
        String job=(String)box.getSelectedItem();
        try{
            Conn conn=new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+salary+"','"+phone+"','"+email+"','"+gender+"','"+job+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added Successfully");
            setVisible(false);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
