package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {
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
        try { cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement();
            int nb = st.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des Peintures' WHERE ID=4");
            //ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
