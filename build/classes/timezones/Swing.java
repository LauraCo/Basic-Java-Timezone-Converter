/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timezones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
        
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        JLabel date = new JLabel();
        date.setText("<html> Local date: " +t.localDate()+"<br> Local time: "+t.localTime()+"</html>");
        
        final JLabel conversion = new JLabel("1",JLabel.CENTER);
        
        Dimension d = conversion.getPreferredSize();  
        conversion.setPreferredSize(new Dimension(d.width+360,d.height));
        
        final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));    
        date.setVisible(true);
        
        frame.add(panel);
        panel.add(date);
        frame.setVisible(true);
        frame.setSize(600,400); 
       
        
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        final JComboBox countries = new JComboBox();
        countries.addItem("Select Place");
        countries.addItem("Europe/Paris");
        countries.addItem("Europe/Berlin");
        countries.addItem("America/New_York");
        
        countries.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + countries.getSelectedIndex()
                     + " Selected item=" + countries.getSelectedItem());
                
                     String out = t.convertJodaTimezone("Europe/London", countries.getSelectedItem().toString());
                    //String out = t.convertTimeZones(countries.getSelectedItem().toString());
                    //JOptionPane.showMessageDialog(null, out);
                    
                     conversion.setText(countries.getSelectedItem().toString() +" : " +out);
                     
                     conversion.setVisible(true);
                   
                     
                     
                    
            }
            
            
            
        });
        conversion.setLocation(300, 400);
        panel.add(conversion);
        frame.add(countries);
    }

}
