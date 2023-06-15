
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    private Border border;
    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(100,100);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/h2.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(210,280,1000,90);
                text.setBorder(border);
                text.setBackground(Color.white);
                text.setForeground(Color.white);
                text.setFont(new Font("serif",Font.BOLD,50));
               
                
                image.add(text);
                 
                JButton next=new JButton("Next");
                next.setBounds(1150,450,150,50);
                next.setBackground(Color.ORANGE);
                next.setForeground(Color.RED);
                next.addActionListener(this);
                next.setFont(new Font("serif",Font.BOLD,25));
                image.add(next);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
