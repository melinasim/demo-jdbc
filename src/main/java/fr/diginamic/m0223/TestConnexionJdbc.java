package fr.diginamic.m0223;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {
    /* private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "root"; */

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle( "db");
        DB_URL = bundle.getString( "db.url");
        DB_USER = bundle.getString( "db.user");
        DB_PWD = bundle.getString( "db.pwd");
    }
    public static void main(String[] args){
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println(cnx);
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        /* finally {
            cnx.close();
        } */

    }
}
