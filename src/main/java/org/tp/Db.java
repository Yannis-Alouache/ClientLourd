package org.tp;
import java.sql.*;

import static java.lang.System.exit;

public class Db {

    private Connection conn;
    public Db(String host, String port, String dbName, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public void close() {

    }

    public ResultSet getTravelerBoatsWithEquipements() {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT bateau.*, GROUP_CONCAT(equipement.libelle SEPARATOR ', ') AS equipements FROM voyageur_equipement, voyageur, bateau, equipement WHERE voyageur_equipement.id_voyageur = voyageur.codeBateau AND voyageur.codeBateau = bateau.codeBateau and equipement.id = voyageur_equipement.id_equipement GROUP BY bateau.nom";
            ResultSet res = stmt.executeQuery(sql);

            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getBoatsName() {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT bateau.nom FROM voyageur, bateau WHERE voyageur.codeBateau = bateau.codeBateau";
            ResultSet res = stmt.executeQuery(sql);
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
