package org.casaortiz.db;

import org.junit.Test;

import java.sql.Connection;

public class DatabaseTest {

    private final ConnectionDB connectionDB = Database.typeDatabase();

    @Test
    public void getConnectionTest(){
        Connection dbConnection = connectionDB.getConnection();
        connectionDB.closeConnection(dbConnection);
    }
}
