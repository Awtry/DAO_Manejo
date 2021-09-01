/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

public class test_Manejo_Dao_Persona {
    public static void main(String[] args) {
        
        Scanner lee = new Scanner(System.in);
        
        PersonaDAO personaDao = new PersonaDAO();
        
        
        int usuario = 0;
        int centi = 0;
        int res = 0;
        
        do{
            
            System.out.println("Bienvenue");
            System.out.println("1 - Traer todos las personas");
            System.out.println("2 - Traer por id");
            System.out.println("3 - Editar por id");
            System.out.println("4 - Eliminar por id");
            System.out.println("0 - Salir");
            
            System.out.println("Dame el número de la función");
            res = lee.nextInt();
            
            
            switch (res) {
                case 1:
                        List<Persona> personas = personaDao.seleccionar();
                        personas.forEach(persona ->
                        {
                             System.out.println(persona);
                         });
                    break;
                case 2:
                    System.out.println("Trabajando en ello");
                    break;
                case 3: 
                    System.out.println("Trabajando en ello");
                    break;
                case 4: 
                    System.out.println("Trabajando en ello");
                    System.out.println("Dame el número del que se elimina.");
                    usuario = lee.nextInt();
                    personaDao.deletePersona(usuario);
                    
                    List<Persona> restantes = personaDao.seleccionar();
                    restantes.forEach(persona ->
                        {
                             System.out.println(persona);
                         });
                    break;
                default:
                    System.exit(1);
            }
            
            System.out.println("");
            System.out.println("¿Quieres regresar al menu? 1- Si / 0 - NO");
            centi = lee.nextInt();
            
        }while(centi != 0);
    }
}
