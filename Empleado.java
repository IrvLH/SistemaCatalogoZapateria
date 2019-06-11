/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaZap;

/**
 *
 * @author Selx
 */
public class Empleado {
    private String idEmple;
    private String usuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String edad;

    public Empleado(String idEmple, String usuario, String contraseña, String nombres, String apellidos, String edad) {
        this.idEmple = idEmple;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad=edad;
    }

    public void setIdEmple(String idEmple) {
        this.idEmple = idEmple;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public String getIdEmple() {
        return idEmple;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEdad() {
        return edad;
    }

    
    
}
