
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    JTextField tfroom,tfprice;
    JComboBox availableOptions,cleans,btype;
    JButton add,cancel;
    
     AddRooms(){
         setBounds(330,200,940,470);
         setLayout(null);
         JLabel heading=new JLabel("ADD ROOMS");
         heading.setFont(new Font("tahoma",Font.BOLD,18));
         heading.setForeground(Color.white);
         heading.setBounds(200,20,200,20);
         add(heading);
         
         JLabel lblroomno=new JLabel("ROOM NUMBER");
         lblroomno.setFont(new Font("tahoma",Font.PLAIN,16));
         lblroomno.setForeground(Color.white);
         lblroomno.setBounds(60,80,120,20);
         add(lblroomno);
         
         tfroom=new JTextField();
           tfroom.setBounds(200,80,150,30);
           add(tfroom);
           
           JLabel lblavailable=new JLabel("AVAILABLE");
         lblavailable.setFont(new Font("tahoma",Font.PLAIN,16));
         lblavailable.setForeground(Color.white);
         lblavailable.setBounds(60,130,120,30);
         add(lblavailable);
                   
         String str[]={"Available","Occupied"};
         availableOptions=new JComboBox(str);
        availableOptions.setBounds(200,130,150,30);
        add(availableOptions);
        
         JLabel lblcleanindstatus=new JLabel("CLEANSTATUS");
        lblcleanindstatus.setFont(new Font("tahoma",Font.PLAIN,16));
         lblcleanindstatus.setForeground(Color.white);
         lblcleanindstatus.setBounds(60,180,120,30);
         add(lblcleanindstatus);
         
          String clean[]={"Cleaned","Dirty"};
         cleans=new JComboBox(clean);
        cleans.setBounds(200,180,150,30);
        add(cleans);
        
        JLabel lblprice=new JLabel("PRICE");
         lblprice.setFont(new Font("tahoma",Font.PLAIN,16));
         lblprice.setForeground(Color.white);
         lblprice.setBounds(60,230,120,30);
         add(lblprice);
         
         tfprice=new JTextField();
           tfprice.setBounds(200,230,150,30);
           add(tfprice);
           
           JLabel lblbedtype=new JLabel("BED TYPE");
        lblbedtype.setFont(new Font("tahoma",Font.PLAIN,16));
         lblbedtype.setForeground(Color.white);
         lblbedtype.setBounds(60,280,120,30);
         add(lblbedtype);
         
           String bed[]={"Single","Double"};
         btype=new JComboBox(bed);
        btype.setBounds(200,280,150,30);
        add(btype);
        
         add=new JButton("ADD ROOM");
         add.setForeground(Color.BLACK);
         add.setBackground(Color.WHITE);
         add.addActionListener(this);
         add.setBounds(60,350,130,30);
         add(add);
         
          cancel=new JButton("CANCEL");
         cancel.setForeground(Color.BLACK);
         cancel.setBackground(Color.WHITE);
         cancel.setBounds(220,350,130,30);
         cancel.addActionListener(this);
         add(cancel);
         
         ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/twelve.jpg"));
         JLabel image=new JLabel(i1);
         image.setBounds(400,30,500,300);
         add(image);   
         getContentPane().setBackground(Color.MAGENTA);
            setVisible(true);
     }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String room=tfroom.getText();
            String available=(String)availableOptions.getSelectedItem();
            String status=(String)cleans.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)btype.getSelectedItem();
         try{
             Conn conn=new Conn();
             String hi = "insert into addroom values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
             conn.s.executeUpdate(hi);
            JOptionPane.showMessageDialog(null, "Room added Successfully");
            setVisible(false);
         }catch(Exception e){
        e.printStackTrace();
    }
        }else{
            setVisible(false);
        }
    }
        
    public static void main(String[] args){
         new AddRooms();
     }
}