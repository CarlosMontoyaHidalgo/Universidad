package kata5p2model;
public class Mail {
    String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    //el histogram se calcula en base a los dominios de loscorreos
    public String getDomain(){
        return this.mail.substring(this.mail.indexOf("@") + 1);
    }
    
    ///ver si alguno no es un correo
    public static boolean isMail(String line){
        return line.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
    
}
