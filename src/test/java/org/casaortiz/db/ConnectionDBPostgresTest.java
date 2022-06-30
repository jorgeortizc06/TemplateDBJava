package org.casaortiz.db;

import org.junit.Test;

import java.sql.Connection;

/**
 * Testing Connection DB Postgresql
 * @author Ing. Jorge Ortiz
 * @version 06/30/2022
 * @see <a href= "https://jorgeortizc06.github.io">Portafolio </a>
 */
public class ConnectionDBPostgresTest {
    private final ConnectionDB connectionDB = new ConnectionDBPostgres();

    @Test
    public void getConnectionTest(){
        Connection dbConnection = connectionDB.getConnection();
        connectionDB.closeConnection(dbConnection);
    }
}
