package kata5p2view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
       
    public static Connection conect() {
        String sql = new String("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Kata5P2\\src\\BaseDatos.db");
        String URL = "jdbc:sqlite:" + sql;
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("CONEXIÓN CONSEGUIDA");
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
        return connection;
    }
}