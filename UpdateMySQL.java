import java.sql.*;
import java.util.*;
public class UpdateMySQL {
    public static void main(String[] args) {
        String status = "Nada aconteceu ainda.";
        Connection conn = App.conectar();
        Scanner scnLogin = new Scanner(System.in);
        Scanner scnSenha = new Scanner(System.in);
        try {
        System.out.println("Bem vindo à tela de login.");
        System.out.println("Digite o login que será cadastrado: ");
        String strLogin = scnLogin.nextLine();
        System.out.println("Digite a senha que será cadastrada: ");
        String strSenha = scnSenha.nextLine();
        String strSqlSelect = "select * from `mysql_connector`.`tbl_login` where `login` = '" + strLogin + "', and `senha` = '" + strSenha + "';";
        Statement stmSql = conn.createStatement();
    ResultSet rsSql = stmSql.executeQuery(strSqlSelect);
    String nomes = "";
    while (rsSql.next()) {
    nomes += "[" + rsSql.getString("nome") + "] ";
 }
    status = "Nome(s): " + nomes;
    stmSql.close();
    rsSql.close();
 } catch (Exception e) {
 System.out.println("Ops! Ocorreu o erro " + e);
 }
 System.out.println(status);
 }
}
