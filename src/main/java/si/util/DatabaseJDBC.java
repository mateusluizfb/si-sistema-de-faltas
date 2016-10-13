package si.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mateus on 13/10/16.
 */
public class DatabaseJDBC {

    private static final String URL = "jdbc:h2:tcp://localhost/~/h2/si-faltas/si-faltas";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro durante a conexao com o banco", e);
        }
    }
}
