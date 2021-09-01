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
        
public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idPersona, Nombre, Apellido, Email, Telefono FROM prueba.persona";
    //private static final String SQL_DELETE = "DELETE "
    
    
    // Método que retorna una lista de objetos, tipo Persona(persona.java)
    public List<Persona> seleccionar()
    {
        //Inicializar parámetros de conexión
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        List<Persona> personas = new ArrayList<>(); 
        
        try
        {
            conn = getConnection();
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
        }catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
            //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerrar todos los objetos
        finally
        {
            try
            {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
   public void deletePersona(int id)
    {
        Connection conn = null;

        try
        {
            //String SQL_DELETE = "DELETE prueba.persona FROM prueba.persona WHERE idPersona = " + id;
            String SQL_DELETE = "DELETE FROM prueba.persona WHERE idPersona = " + id;
            conn = getConnection();
            
            Statement estate = conn.createStatement();
            estate.executeUpdate(SQL_DELETE);
       
        }catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        // Cerrar todos los objetos
        finally
        {
            try
            {
                
                Conexion.close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }

    }
}
