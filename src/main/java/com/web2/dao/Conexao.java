/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection conexao = null;
    private static String url = "jdbc:postgresql://ec2-23-23-142-5.compute-1.amazonaws.com:5432/d4af9aghobejck?ssl=true";
    private static String user = "qcumqkhmaybihi";
    private static String password = "6ac840c144e720fbe4294ad5a0d045f25ab37bf14f16c9c5dd83295ff1b9fe11";
    
    private static PreparedStatement ps;
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
            //conexao = DriverManager.getConnection(url, user, password);
            conexao = DriverManager.getConnection(System.getenv("JDBC_DATABASE_URL"));
     
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS usuario(\n" +
                            "	idUsuario serial primary key,\n" +
                            "    nomeUsuario text not null,\n" +
                            "    emailUsuario text not null,\n" +
                            "    senhaUsuario text not null\n" +
                            ");").executeUpdate();
            
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS professor(\n" +
                                        "	idProfessor serial primary key,\n" +
                                        "    nomeProfessor text not null\n" +
                                        ");").executeUpdate();
            
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS orientacao(\n" +
                                        "	idOrientacao serial primary key,\n" +
                                        "    descricaoOrientacao text not null,\n" +
                                        "    orientadoOrientacao text not null,\n" +
                                        "    idProfessorOrientacao int not null,\n" +
                                        "    CONSTRAINT fkProfessorOrientacao FOREIGN KEY (idProfessorOrientacao) REFERENCES professor (idProfessor)\n" +
                                        ")").executeUpdate();
                      
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection Conector() {
        return conexao;
    }
    
}
