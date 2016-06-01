/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import static BasedeDatos.Rutas.connectionURL;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dawn_
 */
public class Metodos {
    public static boolean addUsuario(Usuario u){
    Connection conn = null;
    try{
         Class.forName(Rutas.driver);
    } catch(java.lang.ClassNotFoundException e) {
         e.printStackTrace();
    }
    try {
        conn = DriverManager.getConnection(connectionURL);

        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO Usuario VALUES('"+u.getNombre()+"','"
        +u.getApellido()+"','"+u.getNick()+"',"+u.getPassword()+",'"
        +u.getDireccion()+"','"+u.getEmail()+"','"+u.getCp()
        +"','"+u.getCiudad()+"','"+u.getTelefono()+"','"+u.getFechaNacimiento()
        +"','"+"'))");
        System.out.println("Se han insertado en registro");
    } catch (Throwable e)  {
         System.out.println("Ha fallado la insercion de dos registros");
    } finally {
    try { conn.close(); }
        catch (Throwable t){
            t.printStackTrace(); 
            return false;

        }

            return false;
        }
    }
    }



