package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");
    }

    public static void main(String[] args) {

        ArrayList<Fournisseur> ListeFournisseurs = new ArrayList<>();
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "-" + rs.getString("Nom"));
                Integer id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Fournisseur currFournisseur = new Fournisseur(id,nom);
                ListeFournisseurs.add(currFournisseur);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        for (Fournisseur currfour: ListeFournisseurs) {
            System.out.println(currfour.getId() + ":" + currfour.getNom());
        }
    }
}
