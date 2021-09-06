package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;

public class Prueba_externa_conexion {
    public static void main(String[] args) {
        Connection conexion = null; 
        try {
             conexion = Conexion.getConnection();
             if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Para no hacer acutomaticamente commit 
            }
             
             PersonaDAO personaDAO = new PersonaDAO(conexion);
             
             Persona actualizarPersona = new Persona();
             
             actualizarPersona.setIdPersona(11);
             actualizarPersona.setNombre("Prueba transaccional");
             actualizarPersona.setApellido("No hay");
             actualizarPersona.setEmail("Noonononon@outlook.es");
             actualizarPersona.setTelefono("4-44-4-4-4-44-44");
            
             personaDAO.actualizar(actualizarPersona);
             
             Persona nuevaPersona = new Persona();
             nuevaPersona.setNombre("Pola");
             nuevaPersona.setApellido("Villa");
             nuevaPersona.setEmail("Kawaii@outlook.es");
             nuevaPersona.setTelefono("878787787");
             personaDAO.insertar(nuevaPersona);
             
             conexion.commit();
             System.out.println("Se realizaron las modificaciones en la base de datos");
             
             Persona EditarPersona = new Persona();
             actualizarPersona.setIdPersona(11);
             nuevaPersona.setNombre("Pola");
             nuevaPersona.setApellido("Villa");
             nuevaPersona.setEmail("Kawaii@outlook.es");
             nuevaPersona.setTelefono("878787787");
             personaDAO.insertar(EditarPersona);
             
              Persona EliminarPersona = new Persona();
             actualizarPersona.setIdPersona(11);
             personaDAO.insertar(EliminarPersona);
             
             conexion.commit();
             System.out.println("Se realizaron las modificaciones en la base de datos");
             
             //Persona personaEditar = new Persona(11,"Coqueta","Woadd","coqueta@correo.com","787878787");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Se entro al rollback - no se realizaron los cambios");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
