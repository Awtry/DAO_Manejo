/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author jorge
 */
public class UsuarioDAO {
    
     //Menejo de conexión = recibe un obj Connection fuera de la clase
    private Connection conexionTransaccional;
    
    
    private static final String SQL_SELECT = "SELECT idUsuario, usuario, password FROM prueba.usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE idUsuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";
    //private static final String SQL_DELETE = "DELETE "
    
        // Pare recibir la conexión 
    public UsuarioDAO(){
    
    }
    
    public UsuarioDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    
    // Método que retorna una lista de objetos, tipo Persona(persona.java)
    public List<Usuario> seleccionar() throws SQLException
    {
        //Inicializar parámetros de conexión
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuarioEntero = null;
        
        List<Usuario> usuarios = new ArrayList<>(); 
        
        try
        {
            //conn = getConnection();
            conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                //Obtener los datos de la BD
                int idUsuario = rs.getInt("idUsuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
           
                        
                usuarioEntero = new Usuario(idUsuario, usuario, password);
                usuarios.add(usuarioEntero);
            }
        }
//        catch(SQLException ex)
//        {
//            ex.printStackTrace(System.out);
//            //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Cerrar todos los objetos
        finally
        {
            try
            {
                Conexion.close(rs);
                Conexion.close(stmt);
                //Conexion.close(conn);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return usuarios;
    }
    
    
    public int insertar(Usuario usuario) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
            //conn = getConnection();
            conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_INSERT); //Por los campos que se 
            //usan se trabaja con strings 
            stmt.setString(1, usuario.getUsuario());  //?
            stmt.setString(2, usuario.getPassword()); //?
        
            
            //Ejecutar sentencia 
            
            registros = stmt.executeUpdate(); // Modifica el estado de la 
            //base de datos INSERT/UPDATE/DELETE
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                //close(conn);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
    
    public int actualizar(Usuario usuario) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
            //conn = getConnection();
             conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE); //Por los campos que se 
            //usan se trabaja con strings 
         
            stmt.setString(1, usuario.getUsuario()); //?
            stmt.setString(2, usuario.getPassword()); //? 
            stmt.setInt(3, usuario.getidUsuario());  //?
            
            
            //Ejecutar sentencia 
            
            registros = stmt.executeUpdate(); // Modifica el estado de la 
            //base de datos INSERT/UPDATE/DELETE
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                //close(conn);
                 if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
    public int eliminar(Usuario usuario) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
            //conn = getConnection();
             conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
           
            stmt.setInt(1, usuario.getidUsuario());
            
            //Ejecutar sentencia 
            
            registros = stmt.executeUpdate(); // Modifica el estado de la 
            //base de datos INSERT/UPDATE/DELETE
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                //close(conn);
                  if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    

}
