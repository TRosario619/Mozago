package mozago.controller;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class point {

	public static ArrayList<String> users = new ArrayList<String>();
	public static ArrayList<String> processos = new ArrayList<String>();
	
	public static Point findScreenCenter(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension mySize = frame.getSize();
		Point fin = new Point(0, 0);

		fin.x = (screenSize.width - mySize.width) / 2;
		fin.y = (screenSize.height - mySize.height) / 2;

		return fin;
	}
	public static String FormatDataAtual(Date date) throws ParseException   
	{   
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   
        GregorianCalendar calendar = new GregorianCalendar();      
        String data = dateFormat.format(date);  
        
        return data;
	}  
	
	 public static BufferedImage loadImage(String file) throws IOException {
	        return ImageIO.read(new File(file));
	    }
	 
	 
	    public static Date somarData (int dias,Date data) {  
	    	Locale locale = new Locale("pt", "PT");  
	        Calendar calendar = Calendar.getInstance(locale);  
	        calendar.setTime(data);  
	        calendar.add(Calendar.DATE, dias);  
	       
	        return calendar.getTime();  
	     }  
	    
	    public static String getDateTime() {
	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    	Date date = new Date();
	    	return dateFormat.format(date);
	    	
	    
	    }


	

}
