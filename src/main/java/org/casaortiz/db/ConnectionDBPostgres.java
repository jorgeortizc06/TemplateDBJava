package org.casaortiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection Database for Postgresql
 * @author Ing. Jorge Ortiz
 * @version 06/30/2022
 * @see <a href= "https://jorgeortizc06.github.io">Portafolio </a>
 */
public class ConnectionDBPostgres implements ConnectionDB{

    private String url = "jdbc:postgresql://localhost:5432/pruebas";
    private String user = "jorge";
    private String pass = "jorge";
    private Connection connect;

    public Connection getConnection(){
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

    public void closeConnection(Connection connect){
        try {
            connect.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            //Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
