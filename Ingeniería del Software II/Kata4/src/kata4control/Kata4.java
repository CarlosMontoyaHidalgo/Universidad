package kata4control;

import java.util.List;
import kata4.Mail;
import kata4.MailHistogramBuilder;
import kata4.MailListReader;
import kata4model.Histogram;
import kata4view.HistogramDisplay;

public class Kata4 {

    public static void main(String[] args) {
        //haremos uso de java swing (contenedores y contenido)
        
        String fileName = new String("email.txt");
        /*I*/List<Mail> mailList = MailListReader.read(fileName);
        /*P*/Histogram histogram = MailHistogramBuilder.build(mailList);
        
        /*
        Histogram<String> histogram = new Histogram<>();
        histogram.increment("gmail.com");
        histogram.increment("ulpgc.com");
        histogram.increment("dis.ulpgc.com");
        histogram.increment("hotmail.es");
        */
        
        /*O*/HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        /*O*/histogramdisplay.execute();
    }
    
}
