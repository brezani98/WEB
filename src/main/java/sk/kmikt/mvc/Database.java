package sk.kmikt.mvc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws NamingException, SQLException {
        DataSource ds;
        Context context;

        context = new InitialContext();
        Context env = (Context) context.lookup("java:/comp/env");
        ds = (DataSource) env.lookup("brezani");
        return  ds.getConnection();
    }


}
