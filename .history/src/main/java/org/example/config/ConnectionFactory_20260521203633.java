package org.example.config;
import sql

public class ConnectionFactory {

    private static final String URL ="jdbc:mysql://localhost:3306/SISTEMA_LOGISTICA?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "mysqlPW";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
