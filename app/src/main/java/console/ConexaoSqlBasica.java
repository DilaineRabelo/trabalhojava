/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoSqlBasica {
    public Connection connection = null;
    
    public ConexaoSqlBasica(){
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:base.db");
        }catch (SQLException e) {System.out.println("Nao foi possivel conectar ao Banco de Dados.");}
    }
    
    public void iniciarBanco(){
        try {
            Statement statement = this.connection.createStatement();            
            statement.executeUpdate("DROP TABLE IF EXISTS ameacas");
            statement.executeUpdate("CREATE TABLE ameacas (id INTEGER PRIMARY KEY AUTOINCREMENT, cve STRING, produto STRING, versao DOUBLE, tipo STRING, criticidade STRING, data DATE, pathCorrecao STRING, solucao STRING, consequencia String)");
            //statement.executeUpdate("INSERT INTO terminalroot VALUES(1, 'Marcos Oliveira')");
            //statement.executeUpdate("INSERT INTO terminalroot VALUES(2, 'James Gosling')");
            //ResultSet rs = statement.executeQuery("SELECT * FROM terminalroot");            
        }catch (SQLException e) {System.out.println("Nao foi possivel alterar ao Banco de Dados.");}
    }
    
    public Connection getConexao(){
        return connection;
    }
    
}

/*  ConexaoSqlBasica conexao = new ConexaoSqlBasica();
        
         PreparedStatement statement = null;
         ResultSet resultSet = null;
         
         
         statement = conexao.c.prepareStatement("SELECT * FROM tasks");
         
         resultSet = statement.executeQuery();
         
         
         while (resultSet.next()){
             System.out.println(resultSet.getString("description"));
         }*/