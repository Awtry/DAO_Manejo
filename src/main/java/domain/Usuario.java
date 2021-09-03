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
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;
    
    public Usuario () { }
    
    public Usuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }
    
    public Usuario(int idUsuario, String usuario, String password)
    {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }
    
    public Usuario(String usuario, String password)
    {
        this.usuario = usuario;
        this.password = password;
    }

    public int getidUsuario() {
        return this.idUsuario;
    }

    public void setId_usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + usuario + ", password=" + password + '}';
    }
}
