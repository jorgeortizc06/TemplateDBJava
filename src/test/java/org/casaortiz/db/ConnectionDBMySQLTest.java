package org.casaortiz.db;

import org.junit.Test;

import java.sql.Connection;

public class ConnectionDBMySQLTest {

    private final ConnectionDB connectionDB = new ConnectionDBMySQL();

    @Test
    public void getConnectionTest(){
        Connection dbConnection = connectionDB.getConnection();
        connectionDB.closeConnection(dbConnection);
    }
}
