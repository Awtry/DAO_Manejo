/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jorge
 */
public class Persona {
    private int idPersona;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Telefono;

    
    public Persona() { }

    //Eliminar
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    //Crear nueva persona
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Email = email;
        this.Telefono = telefono;
    }
    
    //Modificación

    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.Nombre= nombre;
        this.Apellido = apellido;
        this.Email = email;
        this.Telefono = telefono;
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return this.Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + Nombre + ", apellido=" + Apellido + ", email=" + Email + ", telefono=" + Telefono + '}';
    }
}