import java.sql.*;
import java.util.*;

public class CreateMySQLInteract {
    public static void main(String[] args) {
        String status = "Nada aconteceu ainda";
        boolean sair = false;
        Scanner scanInput = new Scanner(System.in);
        Scanner sairScanner = new Scanner(System.in);
        while (sair == false) {
       
        try { 
            
            System.out.println("Digite o nome da tabela:");
            String strNomeTabela = scanInput.nextLine();
            System.out.println("Digite o nome dos campos:");
            String strNomeCampo1 = scanInput.nextLine();
            String strNomeCampo2 = scanInput.nextLine();
            String strNomeCampo3 = scanInput.nextLine();
            String strNomeCampo4 = scanInput.nextLine();  
            String str1 = "CREATE TABLE `mysql_conector`.`";
            String str2 = "`idnew_table` INT NOT NULL AUTO_INCREMENT,";
            String str3 = strNomeCampo1 + " VARCHAR(255) NULL,";
            String str4 = strNomeCampo2 + " VARCHAR(255) NULL,";
            String str5 = strNomeCampo3 + " VARCHAR(255) NULL,";
            String str6 = strNomeCampo4 + " VARCHAR(255) NULL,";
            String str7 = "PRIMARY KEY (`idnew_table`))";

            String strCreateTable = str1 + strNomeTabela + str2 + strNomeCampo1 + str3 + strNomeCampo2 + str4 + strNomeCampo3 + str5 + strNomeCampo4 + str6 + str7;
            Connection conn = App.conectar();
            Statement stmSql = conn.createStatement();
            stmSql.addBatch(strCreateTable);
            stmSql.executeBatch();
            stmSql.close();
            scanInput.close();
            status = "Ok! Tabela criada com sucesso.";
         } catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro " + e);
         }
         System.out.println(status);
        }   
        
            System.out.println("Você deseja sair do programa? Digite 1 para 'Sim' ou 2 para 'Não'.");
            if (sairScanner.equals(1)) {
                System.out.println("Obrigado pela preferência");
                sair=true;
            }
            sairScanner.close();
    }
}
