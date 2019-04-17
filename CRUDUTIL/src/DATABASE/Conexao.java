package DATABASE;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
 

public class Conexao {
 
    //Dados para a conex�o com o banco
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/agenda?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
 
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
 
        Connection conn = null;
        try {
            Class.forName(DRIVER_CONEXAO);
            conn = (Connection) DriverManager.getConnection(STR_CONEXAO , USUARIO, SENHA);
 
            return conn;
 
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(
                    "Driver MySql n�o foi encontrado " + e.getMessage());
 
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar "
                    + "com a base de dados" + e.getMessage());
        }
    }
 
    public static void fechaConexao(Connection conn) {
 
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Fechada a conex�o com o banco de dados");
            }
 
        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados " + e.getMessage());
        }
    }
 
    public static void fechaConexao(java.sql.Connection conn, PreparedStatement stmt) {
 
        try {
            if (conn != null) {
                fechaConexao((Connection) conn);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }
 
 
        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar o statement " + e.getMessage());
        }
    }
 
    public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {
 
        try {
            if (conn != null || stmt != null) {
                fechaConexao(conn, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
 
 
        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
        }
    }
}