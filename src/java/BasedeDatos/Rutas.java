/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

/**
 *
 * @author Dawn_
 */
public class Rutas {
 
    
    static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static String dbName = "/DerbyDB/mundoAnimal";
    static String connectionURL = "jdbc:derby:" + dbName;
    
}
