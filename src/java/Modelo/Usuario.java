package Modelo;

import java.sql.Date;

/**
 *
 */
public class Usuario {

     
    private String nombre;
    private String apellido;
    private String nick;
    private String password;
    private final String direccion;
    private String email;
    private int cp;
    private String poblacion; 
    private String ciudad; 
    private int movil;
    private int telefono;
    private int fechaNacimiento;



    public Usuario(String nombre,String apellido, String nick,String password, String direccion,String email, int cp,String poblacion,String ciudad,int movil,int telefono, int fechaNacimiento) {
        
        this.nombre=nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.password = password;
        this.direccion = direccion;
        this.email = email;
        this.cp=cp;
        this.poblacion = poblacion;
        this.ciudad = ciudad;
        this.movil = movil;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;

    } 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
  public String getDireccion() {
        return direccion;
    }

    /**
     * @return the poblacion
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * @return the movil
     */
    public int getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(int movil) {
        this.movil = movil;
    }
 
}