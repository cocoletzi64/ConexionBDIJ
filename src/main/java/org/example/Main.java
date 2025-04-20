package org.example;

import org.example.jdbc.util.ConexionBD;

import java.sql.*;
public class Main {
    public static void main(String[] args) {

        try(Connection conn = ConexionBD.getInstance();
            Statement stmst=conn.createStatement();
            ResultSet resultado=stmst.executeQuery("SELECT*FROM pacientes"))
        {
            while (resultado.next()){
                System.out.print(resultado.getInt("ID_paciente"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre_paciente"));
                System.out.print(" | ");
                System.out.print(resultado.getString("fecha_nacimiento"));
                System.out.print(" | ");
                System.out.println(resultado.getString("especie"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}