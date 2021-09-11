/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;


public class test_Manejo_Dao_Usuario {
    public static void main(String[] args) {
        
         Scanner lee = new Scanner(System.in);
        /*
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int entrada = 0;
        int centi = 0;
        int res = 0;
        
        String NomUsuario = ""; 
        String ContraUsuario = "";
        
        
        do{
            
            System.out.println("Bienvenue");
            System.out.println("1 - Traer todos los usuarios");
            System.out.println("2 - Agregar");
            System.out.println("3 - Editar por id");
            System.out.println("4 - Eliminar por id");
            System.out.println("0 - Salir");
            
            System.out.println("Dame el número de la función");
            res = lee.nextInt();
            
            
            switch (res) {
                case 1:
                        List<Usuario> users = usuarioDao.seleccionar();
                        users.forEach(usuario ->
                        {
                             System.out.println(usuario);
                         });
                    break;
                case 2:
                    System.out.println("Trabajando en ello");
                    System.out.println("Dame el nombre del usuario");
                    NomUsuario = lee.next();
                    System.out.println("Dame la contraseña");
                    ContraUsuario = lee.next();
                    
                    Usuario usuarioAgregar = new Usuario(NomUsuario, ContraUsuario);
                    usuarioDao.insertar(usuarioAgregar);
        
                    List<Usuario> personasAgre = usuarioDao.seleccionar();
                        personasAgre.forEach(UserAgregar ->
                        {
                             System.out.println(UserAgregar);
                         });
        
                    
                    break;
                case 3: 
                    System.out.println("Trabajando en ello");
                    System.out.println("Dame el id del usuario a editar");
                    entrada = lee.nextInt();
                    System.out.println("Dame el nombre de usuario nuevo");
                    NomUsuario = lee.next();
                    System.out.println("Dame la nueva contraseña");
                    ContraUsuario = lee.next();
                    Usuario usuarioEditar = new Usuario(entrada, NomUsuario, ContraUsuario);
                    usuarioDao.actualizar(usuarioEditar);
         
                    List<Usuario> usuarioActu = usuarioDao.seleccionar();
                        usuarioActu.forEach(usuarioAct ->
                        {
                             System.out.println(usuarioAct);
                         });
                    break;
                case 4: 
                    System.out.println("Trabajando en ello");
                    System.out.println("Dame el número del que se elimina.");
                    entrada = lee.nextInt();
                     Usuario personaELiminar = new Usuario(entrada);
                     usuarioDao.eliminar(personaELiminar);
                     List<Usuario> usEliminado = usuarioDao.seleccionar();
                        usEliminado.forEach(miUser ->
                        {
                             System.out.println(miUser);
                         });
                    break;
                default:
                    System.exit(1);
            }
            
            System.out.println("");
            System.out.println("¿Quieres regresar al menu? 1- Si / 0 - NO");
            centi = lee.nextInt();
            
        }while(centi != 0);*/
    }
    
}
