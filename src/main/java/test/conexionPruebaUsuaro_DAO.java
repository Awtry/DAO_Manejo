package test;


import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.*;



public class conexionPruebaUsuaro_DAO {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null; 
        
        //TODO: instancia procesos almacenados
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Scanner lee = new Scanner(System.in);
            //TODO: instancia seleccionar
            //List<Usuario> visualizarUsuarios = usuarioDao.seleccionar();
            //TODO: instancia insertar
            Usuario insertarUsuario = new Usuario();
            //TODO: instancia actualizar
            Usuario actualizarUsuario = new Usuario();
            //TODO: instancia eliminar
            Usuario eliminarUsuario = new Usuario();



            //Leer datos que ingrese usuario
            int id;
            String op, username, password;
            Scanner leer = new Scanner(System.in);

            //Menú ciclico 
            int centi = 0;
            int res = 0;
            
            
            do {
                //TODO: Mostrar menu
                System.out.println(" --- MENÚ --- ");
                System.out.println("1: Visualizar Usuarios ");
                System.out.println("2: Insertar ");
                System.out.println("3: Actualizar ");
                System.out.println("4: Eliminar ");
                System.out.println("5: Salir ");
                System.out.println("--- Opcion elegida ---");
                res = lee.nextInt();
                
                
            switch(res)
            {
                case 1:
                    //TODO: ciclo que recorre una lista en la que se encuentran guardas los usaurios existentes en la BD
                    System.out.println("--- Dadas de Alta:  ---");
                    List<Usuario> visualizarUsuarios = usuarioDao.seleccionar();
                    visualizarUsuarios.forEach(persona ->{
                        System.out.println(persona);
                    });
                    //JOptionPane. showMessageDialog (null, "Personas", "Visualizar Personas", JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 2:
                    System.out.println("--------------------------");
                    System.out.println("Username: ");
                    username=leer.next();
                    insertarUsuario.setUsuario(username);

                    System.out.println("Password: ");
                    password=leer.next();
                    insertarUsuario.setPassword(password);
                   
                    {
                        try {
                            usuarioDao.insertar(insertarUsuario);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    System.out.println("-------------------------");
                    System.out.println("--- Usuario agregado: ---");
                    System.out.println(insertarUsuario);
                break;


                case 3:

                    System.out.println("¿Quien?:  ");
                    id=leer.nextInt();
                    actualizarUsuario.setId_usuario(id);

                    System.out.println("Username: ");
                    username=leer.next();
                    actualizarUsuario.setUsuario(username);

                    System.out.println("Password: ");
                    password=leer.next();
                    actualizarUsuario.setPassword(password);

                    {
                        try {
                            usuarioDao.actualizar(actualizarUsuario);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    System.out.println("--- Persona actualizada: ---");
                    System.out.println(actualizarUsuario);
                break;


                case 4:
                    
                    System.out.println("¿Quien?: ");
                    id=leer.nextInt();
                    eliminarUsuario.setId_usuario(id);

                    {
                        try {
                            usuarioDao.eliminar(eliminarUsuario);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("--- Persona eliminada: ---");
                    System.out.println(eliminarUsuario);
                       
                    break;

                case 5:
                     System.exit(0);
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("--------------------------");
                    System.out.println("--- ERROR: lo sentimos no hay una opción: -"+res+"- disponible");
                    break;
            }
            
                System.out.println("--------------------------");
                System.out.println("Se realizaron correctamente las modificaciones en la BD");

                System.out.println("");
                System.out.println("¿Quieres regresar al menu? 1- Si / 0 - NO");
                centi = lee.nextInt();
            
            } while (centi != 0);

            
            
            
            
            

            
    }
}
