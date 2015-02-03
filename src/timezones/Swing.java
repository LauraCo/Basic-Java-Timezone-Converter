/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timezones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Expression lac32 is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Swing extends JFrame {
    
    Timezones t = new Timezones();
    
    public Swing()  {
    
     
        JFrame frame = new JFrame(); 
        frame.setTitle("TimeZone Converter");
        
         
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
       
        JLabel blank = new JLabel();
        JLabel date = new JLabel();
        date.setText("<html> Local date: " +t.localDate()+"<br> Local time: "+t.localTime()+"</html>");
        
        final JLabel conversion = new JLabel("",JLabel.CENTER);
        
        Dimension d = conversion.getPreferredSize();  
       // conversion.setMinimumSize(300);
        
        final JPanel topPanel = new JPanel();   
        final JPanel bottomPanel = new JPanel();    
        
        date.setVisible(true);
        
        frame.add(topPanel);
        frame.add(bottomPanel);
        topPanel.add(blank);
        topPanel.add(date);
        frame.setVisible(true);
        frame.setSize(600,400); 
       
        
        topPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        final JComboBox countries = new JComboBox();
        countries.addItem("Select Place");
        countries.addItem("Europe/Paris");
        countries.addItem("Europe/Berlin");
        countries.addItem("America/New_York");
        countries.addItem("Pacific/Pago_Pago");
        countries.addItem("Pacific/Fiji");
        countries.addItem("Australia/Brisbane");
        countries.addItem("America/Los_Angeles");
        
        countries.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + countries.getSelectedIndex()
                     + " Selected item=" + countries.getSelectedItem());
                
                     String out = t.convertJodaTimezone("Europe/London", countries.getSelectedItem().toString());
                     conversion.setText(countries.getSelectedItem().toString() +" : " +out);
                     
                     conversion.setVisible(true);
                   
                     
                     
                    
            }
            
            
            
        });
        conversion.setLocation(300, 400);
        bottomPanel.add(countries);
        bottomPanel.add(conversion);
        
    }

}
