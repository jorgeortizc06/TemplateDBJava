package org.casaortiz.db;

public class Database {
    public static ConnectionDB typeDatabase(){
        return new ConnectionDBMySQL();
    }
}
