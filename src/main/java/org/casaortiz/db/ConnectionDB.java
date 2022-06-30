package org.casaortiz.db;

import java.sql.Connection;

public interface ConnectionDB {
    Connection getConnection();
    void closeConnection(Connection connect);
}
