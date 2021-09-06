/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class PersonaDAO {
    
    //Menejo de conexión = recibe un obj Connection fuera de la clase
    private Connection conexionTransaccional;
    
    
    private static final String SQL_SELECT = "SELECT idPersona, Nombre, Apellido, Email, Telefono FROM prueba.persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";
    //private static final String SQL_DELETE = "DELETE "
    
    
    
    // Pare recibir la conexión 
    public PersonaDAO(){
    
    }
    
    public PersonaDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    
    
    
    // Método que retorna una lista de objetos, tipo Persona(persona.java)
    public List<Persona> seleccionar() throws SQLException
    {
        //Inicializar parámetros de conexión
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        List<Persona> personas = new ArrayList<>(); 
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            //conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                //Obtener los datos de la BD
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String email = rs.getString("Email");
                String telefono = rs.getString("Telefono");
                        
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
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
        
        return personas;
    }
    
    
    public int insertar(Persona persona) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
           // conn = getConnection();
            conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_INSERT); //Por los campos que se 
            //usan se trabaja con strings 
            stmt.setString(1, persona.getNombre());  //?
            stmt.setString(2, persona.getApellido()); //?
            stmt.setString(3, persona.getEmail()); //? 
            stmt.setString(4, persona.getTelefono()); //?
            
            //Ejecutar sentencia 
            
            registros = stmt.executeUpdate(); // Modifica el estado de la 
            //base de datos INSERT/UPDATE/DELETE
        } 
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                  if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
    
    public int actualizar(Persona persona) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
            //conn = getConnection();
            conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE); //Por los campos que se 
            //usan se trabaja con strings 
            stmt.setString(1, persona.getNombre());  //?
            stmt.setString(2, persona.getApellido()); //?
            stmt.setString(3, persona.getEmail()); //? 
            stmt.setString(4, persona.getTelefono()); //?
            stmt.setInt(5, persona.getIdPersona());
            
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
                  if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
    public int eliminar(Persona persona) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; // Saber cuantos registros se han actualizado
        try {
           // conn = getConnection();
           conn = this.conexionTransaccional != null ? this.conexionTransaccional: getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
           
            stmt.setInt(1, persona.getIdPersona());
            
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
                  if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
    
   public void deletePersona(int id) throws SQLException
    {
        Connection conn = null;

        try
        {
            //String SQL_DELETE = "DELETE prueba.persona FROM prueba.persona WHERE idPersona = " + id;
            String SQL_DELETE = "DELETE FROM prueba.persona WHERE idPersona = " + id;
            conn = getConnection();
            
            Statement estate = conn.createStatement();
            estate.executeUpdate(SQL_DELETE);
       
        }
//        catch(SQLException ex)
//        {
//            ex.printStackTrace(System.out);
//        }
        // Cerrar todos los objetos
        finally
        {
            try
            {
                
                  if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }

    }
}
