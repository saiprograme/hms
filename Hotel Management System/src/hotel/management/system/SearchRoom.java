package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox type;
    JCheckBox available;
    SearchRoom(){
       setBounds(300,200,1050,600);
       getContentPane().setBackground(Color.ORANGE);
       setLayout(null);
       JLabel text=new JLabel("SEARCH FOR ROOM");
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       text.setBounds(400,30,200,30);
       add(text);
       
       JLabel lblbed=new JLabel("BED TYPE");
       lblbed.setBounds(50, 100, 100, 20);
       add(lblbed);
       
       String str[]={"Single","Double"};
       type=new JComboBox(str);
       type.setBounds(150,100,150,25);
       add(type);
       
       available=new JCheckBox("only display available");
       available.setBounds(650,100,150,25);
       add(available);
       
       
       JLabel l1=new JLabel("ROOM NUMBER");
       l1.setBounds(10,170,100,20);
       add(l1);
       
       JLabel l2=new JLabel("AVAILABLE");
       l2.setBounds(200,170,100,20);
       add(l2);
       
       JLabel l3=new JLabel("STATUS");
       l3.setBounds(390,170,100,20);
       add(l3);
       
       JLabel l4=new JLabel("PRICE");
       l4.setBounds(600,170,100,20);
       add(l4);
       
       JLabel l5=new JLabel("BEDTYPE");
       l5.setBounds(800,170,100,20);
       add(l5);

       


       
       table=new JTable();
       table.setBounds(0, 200, 1000, 300);
       add(table);
       
       
       back=new JButton("BACK");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.setBounds(500,520,120,30);
       back.addActionListener(this);
       add(back);
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from addroom");
            table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           e.printStackTrace();
       }
       
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
            
                String query1="select * from addroom where type='"+type.getSelectedItem()+"'";
                String query2="select * from addroom where available= 'Available' AND '"+type.getSelectedItem()+"'";
                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }else{
                    rs=conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
                
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}

