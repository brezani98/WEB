package sk.kmikt.mvc.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DB {

    public static Connection getConnection() throws NamingException, SQLException {
        DataSource ds;
        Context initContext;

        initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        ds = (DataSource) envContext.lookup("pool1");

        return ds.getConnection();
    }
}
