import org.casaortiz.db.ConnectionDBPostgres;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        ConnectionDBPostgres con = new ConnectionDBPostgres();
        Connection con1 = con.getConnection();
        con.closeConnection(con1);
    }
}
