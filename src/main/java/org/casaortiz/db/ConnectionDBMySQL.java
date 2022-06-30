package org.casaortiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBMySQL implements ConnectionDB{
    private String url = "jdbc:mysql://localhost:3306/pruebas";
    private String user = "root";
    private String pass = "jorge";
    private Connection connect;
    @Override
    public Connection getConnection() {
        try {
            connect = DriverManager.getConnection(url, user, pass);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
        return connect;
    }

    @Override
    public void closeConnection(Connection connect) {

    }
}
