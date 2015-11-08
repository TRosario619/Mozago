package mozago.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

    public class BlockingGlassPane extends JPanel {  
        public BlockingGlassPane() {  
            setOpaque(false);  
           
        }  
      
        protected void paintComponent(Graphics g) {  
            Graphics2D g2 = (Graphics2D) g.create();  
            // fill the component with the translucent color  
            g2.setColor(new Color(0, 0, 0, 128));  
            g2.fillRect(0, 0, getWidth(), getHeight());  
            g2.dispose();  
        }  
    }  