/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;
import ModeloDB.UsuarioDB;
import Modelo.Usuario;
import java.sql.Date;

/**
 *
 * @author Roberto
 */
public class Prueba {
    
    public static void main(String args[]){
        Date fecha = new Date(1998,05,15);
        System.out.println("primero");
        Usuario usuario = new Usuario(0,"Alba","Fancisco Gutierrez","albfran","1234","calle inventada, 123",34008,"alba@no.com","Palencia","Palencia",123456789,fecha);
        UsuarioDB.insertar(usuario);
        System.out.println("acaba");
        
    }
    
}
