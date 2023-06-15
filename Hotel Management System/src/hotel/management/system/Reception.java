
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener {
    Reception(){
        setBounds(350,200,800,570);
        setLayout(null);
        
        JButton newcustomer=new JButton("NEW CUSTOMER FORM");
        newcustomer.setBounds(10, 30, 200, 30);
        newcustomer.setBackground(Color.lightGray);
        newcustomer.setForeground(Color.BLACK);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        JButton rooms =new JButton("ROOMS");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.lightGray);
        rooms.setForeground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        JButton dept =new JButton("DEPARTMENTS");
        dept.setBounds(10, 110, 200, 30);
        dept.setBackground(Color.lightGray);
        dept.setForeground(Color.BLACK);
        dept.addActionListener(this);
        add(dept);
        
         JButton allemployee =new JButton("ALL EMPLOYEE");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.lightGray);
        allemployee.setForeground(Color.BLACK);
        allemployee.addActionListener(this);
        add(allemployee);
        
        JButton customer =new JButton("CUSTOMER INFO");
        customer.setBounds(10, 190, 200, 30);
        customer.setBackground(Color.lightGray);
        customer.addActionListener(this);
        customer.setForeground(Color.BLACK);
        add(customer);
        
        JButton manager =new JButton("MANAGER INFO");
        manager.setBounds(10, 230, 200, 30);
        manager.setBackground(Color.lightGray);
        manager.setForeground(Color.BLACK);
        manager.addActionListener(this);
        add(manager);
        
       
         JButton checkout =new JButton("CHECKOUT");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.lightGray);
        checkout.setForeground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
         JButton penstatus =new JButton("UPDATE STATUS");
        penstatus.setBounds(10, 310, 200, 30);
        penstatus.setBackground(Color.lightGray);
        penstatus.setForeground(Color.BLACK);
        penstatus.addActionListener(this);
        add(penstatus);
        
        JButton roomstatus =new JButton("UPDATE ROOM STATUS");
        roomstatus.setBounds(10, 350, 200, 30);
        roomstatus.setBackground(Color.lightGray);
        roomstatus.setForeground(Color.BLACK);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        JButton pickup =new JButton("PICKUP SERVICE");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.lightGray);
        pickup.setForeground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
        JButton search =new JButton("SEARCH ROOM");
        search.setBounds(10, 430, 200, 30);
        search.setBackground(Color.lightGray);
        search.setForeground(Color.BLACK);
        search.addActionListener(this);
        add(search);
        
        JButton logout =new JButton("LOGOUT");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.lightGray);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        getContentPane().setBackground(Color.MAGENTA);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("NEW CUSTOMER FORM")){
            new AddCustomer();
        } else if(ae.getActionCommand().equals("ROOMS")){
            new Rooms();
        }else if(ae.getActionCommand().equals("DEPARTMENTS")){
            new Department();
        }else if(ae.getActionCommand().equals("ALL EMPLOYEE")){
            new AllEmployee();
        }else if(ae.getActionCommand().equals("MANAGER INFO")){
            new ManagerInfo();
    }else if(ae.getActionCommand().equals("CUSTOMER INFO")){
            new CustomerInfo();
    }
        else if(ae.getActionCommand().equals("UPDATE STATUS")){
            new UpdateCheck();
    }
        else if(ae.getActionCommand().equals("UPDATE ROOM STATUS")){
            new UpdateRoom();
    } else if(ae.getActionCommand().equals("PICKUP SERVICE")){
            new PickupService();
    }else if(ae.getActionCommand().equals("SEARCH ROOM")){
            new Rooms();
    }else if(ae.getActionCommand().equals("CHECKOUT")){
            new Checkout();
    }else if(ae.getActionCommand().equals("LOGOUT")){
            setVisible(false);
    }
    }
   public static void main(String[] args){
        new Reception();

}
}