/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timezones;

import java.awt.EventQueue;




/**
 *
 * @author lauracollins
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing window = new Swing();
                window.setVisible(true);
     }
        }); 
        Timezones t = new Timezones();
        
        
        
    }
}     

