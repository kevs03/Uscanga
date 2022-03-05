package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kevin
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uscangainmobiliaria", "root","");
        } catch (Exception e) { 
            System.out.println(String.valueOf(e));
        }
        return con;
    }
}
