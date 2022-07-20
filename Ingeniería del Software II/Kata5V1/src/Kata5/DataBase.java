package Kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class DataBase {
    private String URL;
    private Connection connection = null;
    
    DataBase(String URL) {
            this.URL = URL;     
    }

    void open() {
        try{
            this.connection = DriverManager.getConnection(this.URL); //acceso a la url gracias driver ,amager
            System.out.println("Base de datos abierta");
        } catch (SQLException exception){
            System.out.println("ERROR DataBase:: open (SQLException)" + exception.getMessage());
        }
    }

    void close() {
        
        try{
            if(this.connection != null)
            this.connection.close();
            System.out.println("Base de datos cerrada.");
        } catch (SQLException exception){
            System.out.println("ERROR DataBase:: open (SQLException)" + exception.getMessage());
        }
    }
    
    void selectPEOPLE(String select) {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = this.connection.createStatement();
            //primero se crea y dps se prepara
            ResultSet resultset = statement.executeQuery(select);
            System.out.println("ID \t APELLIDOS \t DEPARTAMENTO");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + "\t" +
                        resultset.getString("Name") + "\t" +
                        resultset.getString("Apellidos") + "\t" +
                        resultset.getString("Departamento") + "\t");
            }
        } catch(SQLException exception){
                System.out.println("ERROR DataBase:: open (SQLException)" + exception.getMessage());
        }
    }

    void insertPEOPLE(People people) {
        String SQL = "INSERT INTO PEOPLE(Name, Apellidos, Departamento) VALUES(?,?,?)";
        try{
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getName());
            preparedstatement.setString(2, people.getApellidos());        
            preparedstatement.setString(3, people.getDepartamento());        
            preparedstatement.executeUpdate();        
        } catch(SQLException exception){
                        System.out.println("ERROR DataBase:: open (SQLException)" + exception.getMessage());
        }
    }
}