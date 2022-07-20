package kata5p2control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import kata5p2model.Mail;
import kata5p2view.MailHistogramBuilder;
import kata5p2model.Histogram;
import kata5p2view.HistogramDisplay;
import static kata5p2view.ConnectionBD.conect;
import static kata5p2view.MailListBuilderBD.selectEmail;
import kata5p2view.MailListReaderBD;

public class Kata5P2 {

    public static void main(String[] args) throws SQLException{
        //haremos uso de java swing (contenedores y contenido)
        Connection conect = conect();
        //String fileName = new String("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Kata5P2\\src\\email.txt.txt");
    /*I*/List<Mail> mailList = MailListReaderBD.read(conect);
    /*P*/Histogram histogram = MailHistogramBuilder.build(mailList);       
    /*O*/HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        selectEmail(conect);
    /*O*/histogramdisplay.execute();
    }
    
}
