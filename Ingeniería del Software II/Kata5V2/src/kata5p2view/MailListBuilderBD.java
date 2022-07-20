/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MailListBuilderBD {
    
    // Método que lee desde el fichero de emails y los inserta en la BD
    
    public static void build(Connection connection) {
        String SQL = "INSERT INTO EMAIL(MAIL) VALUES (?)";
        List<String> emails = MailListReader.read("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\Kata5P2\\src\\email.txt.txt");   
        try {
            for(String email : emails){
                PreparedStatement preparedstatement = connection.prepareStatement(SQL);
                preparedstatement.setString(1, email);
                preparedstatement.executeUpdate();
            }
        }
        catch(SQLException exception) {
            System.out.println("Error en Kata5::preparedStatement(SQLException) " + exception.getMessage());
        }
    }
    
    // Método que selecciona todos los campos de la tabla EMAIL
    
    public static void selectEmail(Connection connection) {
        String sql = "SELECT * FROM EMAIL";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            System.out.println("Id \t Mail");
            while(resultset.next()) {
                System.out.println(resultset.getInt("Id") + "\t " + resultset.getString("Mail"));
            }
        }
        catch(SQLException exception) {
            System.out.println("Error" + exception.getMessage());
        }
    }
}