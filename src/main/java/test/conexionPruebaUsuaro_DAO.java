package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.*;



public class conexionPruebaUsuaro_DAO {
    public static void main(String[] args) {
        Connection conexion = null; 
        
        try {
             conexion = Conexion.getConnection();
             if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Para no hacer acutomaticamente commit 
            }
             
             UsuarioDAO personaDAO = new UsuarioDAO(conexion);
             
             Usuario actualizarPersona = new Usuario();
             
             actualizarPersona.setId_usuario(1);
             actualizarPersona.setUsuario("Prueba transaccional");
             actualizarPersona.setPassword("No hay");     
            
             personaDAO.actualizar(actualizarPersona);
             
             Usuario nuevaPersona = new Usuario();
             nuevaPersona.setUsuario("Pola");
             nuevaPersona.setPassword("Villa");
             personaDAO.insertar(nuevaPersona);
             
             conexion.commit();
             System.out.println("Se realizaron las modificaciones en la base de datos");
             
             Usuario EditarPersona = new Usuario();
             actualizarPersona.setId_usuario(11);
             nuevaPersona.setUsuario("Pola");
             nuevaPersona.setPassword("Villa");
       
             personaDAO.insertar(EditarPersona);
             
              Usuario EliminarPersona = new Usuario();
             actualizarPersona.setId_usuario(11);
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
