package kata4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public static List<Mail> read(String fileName) {
        List<Mail> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            
            while(true){ //esta feo
            String line = reader.readLine();
            if (line == null)
                break;
            if(Mail.isMail(line))
                list.add(new Mail(line));
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("No se encontro archivo");
        }
        catch(IOException exception){
            System.out.println("Fallo");
        }
        return list;
    }
}
