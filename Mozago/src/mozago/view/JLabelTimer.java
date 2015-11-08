package mozago.view;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author test
 */
public class JLabelTimer extends JLabel{

    private static final DateFormat FORMATO = new SimpleDateFormat("HH'h':mm'm':ss's'"); 

    public JLabelTimer() {
        Thread clockThread = new Thread(new ClockRunnable(), "Clock thread");  
        clockThread.setDaemon(true);  
        clockThread.start();
    }

    public void setHora(Date date) {  
        setText(FORMATO.format(date));  
    }

    private class ClockRunnable implements Runnable {  
        @Override
        public void run() {  
            try {  
                while (true) {  

                    EventQueue.invokeLater(new Runnable() {  
                        @Override
                        public void run() {  

                            setHora(new Date());  
                        }  
                    });  

                    Thread.sleep(1000);  
                }  
            }  
            catch (InterruptedException e) {  
            }  
        }  
    }  
}