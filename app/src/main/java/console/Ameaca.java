/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package console;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Ameaca {
    private int id;
    private String cve;
    private String produto;
    private double versao;
    private String tipo;  
    private String criticidade;
    private Date data;
    private String pathCorrecao;
    private String solucao;
    private String consequencia;

     public int inserirAmeaca() throws SQLException {
        Connection con = new ConexaoSqlBasica().getConexao();        
         
        String sql = "INSERT INTO ameacas ('cve', 'produto', 'versao', 'tipo', 'criticidade', 'data', 'pathCorrecao', 'solucao', 'consequencia') VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, cve);
        statement.setString(2, produto);
        statement.setDouble(3, versao);
        statement.setString(4, tipo);
        statement.setString(5, criticidade);
        statement.setDate(6,  null);
        statement.setString(7, pathCorrecao);
        statement.setString(8, solucao);
        statement.setString(9, consequencia);        
        int execute = statement.executeUpdate();
        return execute;
    }
     
    public List<Ameaca> getAmeacas() throws SQLException{
        Connection con = new ConexaoSqlBasica().getConexao(); 
        List<Ameaca>ameacas = new ArrayList<Ameaca>();
        Statement statement = con.createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("SELECT * FROM ameacas");
        while(rs.next()){
            Ameaca ameaca = new Ameaca();
            ameaca.setCve(rs.getString("cve"));
            ameaca.setProduto(rs.getString("produto"));
            ameacas.add(ameaca);
        }
        return ameacas;
    }
    
    public Ameaca getAmeaca() throws SQLException{
        Connection con = new ConexaoSqlBasica().getConexao(); 
        Statement statement = con.createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("SELECT * FROM ameacas WHERE id =" + this.id);
        rs.next();
            Ameaca ameaca = new Ameaca();
            ameaca.setCve(rs.getString("cve"));
            ameaca.setProduto(rs.getString("produto"));        
    
        return ameaca;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getVersao() {
        return versao;
    }

    public void setVersao(double versao) {
        this.versao = versao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPathCorrecao() {
        return pathCorrecao;
    }

    public void setPathCorrecao(String pathCorrecao) {
        this.pathCorrecao = pathCorrecao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getConsequencia() {
        return consequencia;
    }

    public void setConsequencia(String consequencia) {
        this.consequencia = consequencia;
    }
    
   
    

}





