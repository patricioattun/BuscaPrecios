
package Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
   
    private static Connection cnn=null;

    public Conexion() throws IOException {
        
    }
    
    public static Connection Cadena(String ip) throws MiExcepcion{
        
        try {
            Connection cnn=null;
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            cnn=DriverManager.getConnection("jdbc:db2://"+ip+":50000/ACE1","admin","desadb2");
            return cnn;
        } catch (ClassNotFoundException ex) {
            throw new MiExcepcion(ex.getMessage());
        } catch (SQLException ex) {
            throw new MiExcepcion(ex.getMessage());
        }
    
    }
    public static Connection CadenaMon() throws ClassNotFoundException, SQLException, UnknownHostException, IOException{
        Connection cnn=null;
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        cnn=DriverManager.getConnection("jdbc:db2://10.136.1.2:50000/ACE1","admin","desadb2");

        return cnn;
    
    }
    
   
  
}
