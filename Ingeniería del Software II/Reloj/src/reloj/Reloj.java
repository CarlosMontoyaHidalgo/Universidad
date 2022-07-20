package reloj;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;


public class Reloj implements Runnable {
    private JLabel label;
    public Reloj(JLabel label) {
        this.label= label;
    }
    public void setLabel(JLabel label) {
        this.label=label;
    }
    public String tiempo1() {
        Date date= new Date(); 
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy"); 
        DateFormat hourDateFormat=new SimpleDateFormat("HH:mm:ss");
        return (hourDateFormat.format(date));
    }
    @Override
    public void run() {
        int i = 1;
        try {
            do{
                this.label.setText(" "+tiempo1()+" ");
            }while(i==1);
        } catch (Exception e) {
        }
    }
    
}