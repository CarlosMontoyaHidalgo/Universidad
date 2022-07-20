package Kata5;
public class Kata5 {
    //trabajamos en local
    public static void main(String[] args) {
        
        //lo que puede que este mal es direccion
        String location = "C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Kata5\\src\\Kata5\\BaseDatos.db";
        String URL = new String ("jdbc:sqlite:" + location);
        DataBase database = new DataBase(URL);
        //CONEXION TIPICA = conectarse y desconectarse
        
        database.open();
        
        
        //database.selectPEOPLE();//Nos permitira ver
        
        People people = new People("Fefo", "Hernández", "Taller");
        database.insertPEOPLE(people);
        database.selectPEOPLE("SELECT * FROM PEOPLE");
        database.close();   
    }
}
