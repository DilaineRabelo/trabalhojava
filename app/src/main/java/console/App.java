/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package console;

import console.Ameaca;
import console.Ameaca;
import console.ConexaoSqlBasica;
import console.ConexaoSqlBasica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void exibir(List<Ameaca>ameacas){
        for(Ameaca ame: ameacas) {
            System.out.println("...........................");
            System.out.println("Id: " + ame.getId() + "," + ame.getProduto());
            System.out.println("...........................");            
        } 
    
    }
    
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    public static void main(String[] args) throws SQLException {
        //ConexaoSqlBasica con = new ConexaoSqlBasica();
        //con.iniciarBanco();
        List<Ameaca>ameacas = new ArrayList<Ameaca>(); 
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
      
        while(opcao!=0){
            System.out.println("1- Inserir uma ameaça");
            System.out.println("2- Remover uma ameaça");
            System.out.println("3- ALterar dados de uma ameaca");     
            System.out.println("4- Listar todas as ameaças");
            System.out.println("0- Fechar");
            opcao = sc.nextInt();
            clearBuffer(sc);

            switch (opcao){
                case 1:
                    Ameaca ameaca = new Ameaca();
                    System.out.println("CVE: \n");
                    String cve = sc.nextLine();
                    ameaca.setCve(cve);
                    System.out.println("Produto: \n");
                    String produto = sc.nextLine();
                    ameaca.setProduto(produto);
                    System.out.println("Versão: \n");
                    double versao = sc.nextDouble();
                    clearBuffer(sc);
                    ameaca.setVersao(versao);
                    System.out.println("Tipo: \n");
                    String tipo = sc.nextLine();
                    ameaca.setTipo(tipo);
                    System.out.println("Criticidade: \n");
                    String criticidade = sc.nextLine();
                    ameaca.setCriticidade(criticidade);
                    ameaca.setData(new Date());
                    System.out.println("PathCorrecao: \n");
                    String path = sc.nextLine();
                    ameaca.setPathCorrecao(path);
                    System.out.println("Solução: \n");
                    String solucao = sc.nextLine();
                    ameaca.setSolucao(solucao);
                    System.out.println("Consequência: \n");
                    String cons = sc.nextLine();
                    ameaca.setConsequencia(cons);
                    int st = ameaca.inserirAmeaca();
                    
                    if(st>0){
                        System.out.println("Registro inserido com sucesso");
                    } else {
                        System.out.println("Erro ao inserir");
                    }
                    break;

                case 2:
                    exibir(ameacas);
                    System.out.println("Qual Id?");
                    int id = sc.nextInt();
                    ameacas.removeIf(a -> a.getId()==id);
                                   
                    break;
                case 4:
                    exibir(ameacas);
                    break;
            }  
        }
        
    }
}
