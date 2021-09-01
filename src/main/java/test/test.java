package test;

import java.sql.*;



public class test {
    public static void main(String[] args) {
        //Cadena de conexión
          String url = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
          
           try {
            // Web Interface
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "Joderastra@mia22");// usuario y contraseña
            Statement intruccion = conexion.createStatement();
            String sql = "SELECT idPersona, Nombre, Apellido, Email, Telefono FROM prueba.persona";
            ResultSet resultado = intruccion.executeQuery(sql); // Ejecuta la consulta de arriba
            // Para recorrer los elementos de la consulta
            while (resultado.next()) {
                System.out.println("Id Persona: "+resultado.getString("idPersona"));
                System.out.println("Nombre: "+resultado.getString("Nombre"));
                System.out.println("Apellidos: "+resultado.getString("Apellido"));
                System.out.println("Email: "+resultado.getString("Email"));
                System.out.println("Telefono: "+resultado.getString("Telefono"));
                System.out.println("\n");
            }
            // cerrar sesión
            resultado.close();
            intruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
}
