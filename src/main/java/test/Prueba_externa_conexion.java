package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class Prueba_externa_conexion {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null; 

            Scanner lee = new Scanner(System.in);
        
            //TODO: instancia procesos almacenados
            PersonaDAO personaDao = new PersonaDAO();
            

            //TODO: instancia seleccionar
            //List<Persona> visualizarPersonas = personaDao.seleccionar();
            //TODO: instancia insertar
            Persona insertarPersona = new Persona();

            //TODO: instancia actualizar
            Persona actualizarPersona = new Persona();
            //TODO: instancia eliminar
            Persona eliminarPersona = new Persona();



            //Leer datos que ingrese usuario
            int id;
            String op, nombre, apellido, email, telefono;
            Scanner leer = new Scanner(System.in);

            //Menú ciclico 
            int usuario = 0;
            int centi = 0;
            int res = 0;
            
            
            

          

            
            do {            
            
                //TODO: Mostrar menu
                  System.out.println(" --- MENÚ --- ");
                  System.out.println("1: Visualizar Personas ");
                  System.out.println("2: Insertar ");
                  System.out.println("3: Actualizar ");
                  System.out.println("4: Eliminar ");
                  System.out.println("5: Salir ");
                  System.out.println("--- Opcion elegida ---");
                  res = lee.nextInt();

            switch(res)
            {
                case 1:
                    
                    //TODO: ciclo que recorre una lista en la que se encuentran guardas las personas existentes en la BD
                    System.out.println("--- Dadas de Alta:  ---");
                    List<Persona> personas = personaDao.seleccionar();
                        personas.forEach(persona ->
                        {
                             System.out.println(persona);
                         });
                    
                    break;

                case 2:
                    System.out.println("--------------------------");
                    System.out.println("Nombre: ");
                    nombre=leer.next();
                    insertarPersona.setNombre(nombre);
                    
                    System.out.println("Apellido: ");
                    apellido=leer.next();
                    insertarPersona.setApellido(apellido);

                    System.out.println("Email: ");
                    email=leer.next();
                    insertarPersona.setEmail(email);

                    System.out.println("Telefono: ");
                    telefono=leer.next();
                    insertarPersona.setTelefono(telefono);
                    {
                        try {
                            personaDao.insertar(insertarPersona);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Persona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    JOptionPane. showMessageDialog (null, "Personas", "Persona agregada conrrectamente", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("-------------------------");
                    System.out.println("--- Persona agregada: ---");
                    System.out.println(insertarPersona);
                break;


                case 3:

                    System.out.println("--------------------------");
                    //System.out.println("--- Disponibles:  ---");
                    //List<Persona> visualizarPersonas = personaDao.seleccionar();
                    //visualizarPersonas.forEach(persona ->{
                    //    System.out.println(persona);
                    //});

                    System.out.println("¿Quien?:  ");
                    id=leer.nextInt();
                    actualizarPersona.setIdPersona(id);

                    System.out.println("Nombre: ");
                    nombre=leer.next();
                    actualizarPersona.setNombre(nombre);

                    System.out.println("Apellido: ");
                    apellido=leer.next();
                    actualizarPersona.setApellido(apellido);

                    System.out.println("Email: ");
                    email=leer.next();
                    actualizarPersona.setEmail(email);

                    System.out.println("Telefono: ");
                    telefono=leer.next();
                    actualizarPersona.setTelefono(telefono);

                    {
                        try {
                            personaDao.actualizar(actualizarPersona);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Persona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    System.out.println("--- Persona actualizada: ---");
                    System.out.println(actualizarPersona);
                break;


                case 4:
                    //System.out.println("--- Disponibles:  ---");
                    //visualizarPersonas.forEach(persona ->{
                    //    System.out.println(persona);
                    //});

                    System.out.println("¿Quien?: ");
                    id=leer.nextInt();
                    eliminarPersona.setIdPersona(id);

                    {
                        try {
                            personaDao.eliminar(eliminarPersona);
                        } catch (SQLException ex) {
                            Logger.getLogger(test_Manejo_Dao_Persona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("--- Persona eliminada: ---");
                    System.out.println(eliminarPersona);
                       
                    break;

                case 5:
                    // personaDao.Cerrar();
                     System.exit(0);
                    break;
                    
                default:
                    System.out.println("\n");
                    System.out.println("--------------------------");
                    System.out.println("--- ERROR: lo sentimos no hay una opción: -"+res+"- disponible");
                    break;
            }
            
            //conexion.commit();
            System.out.println("--------------------------");
            System.out.println("Se realizaron correctamente las modificaciones en la BD");

            System.out.println("");
            System.out.println("¿Quieres regresar al menu? 1- Si / 0 - NO");
            centi = lee.nextInt();
                
            } while (centi != 0);
            
           
            
    }
}
