/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static String url = "jdbc:mysql://localhost:3306/Centre_Medical_db?useSSL=false&serverTimezone=UTC";
    private static String login = "root";
    private static String password = "";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Connected.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver non charge");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
            System.out.println("Impossible d'etablir la connexion");
        }
    }

    public static Connection getConnection() {
        return connection;
    }


    public static void main(String[] args) {
        getConnection();
    }
   
}
