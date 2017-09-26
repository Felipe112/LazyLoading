/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fray
 */
public class Conectar {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String server = "jdbc:mysql://localhost:3306/DB_lazy_loading";

    public Conectar() {
       conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(server, user, pass);
            if(conn != null){
                System.out.println("conecto");
            }
            
        } catch (ClassNotFoundException | SQLException e) {

        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
    }
            

}
