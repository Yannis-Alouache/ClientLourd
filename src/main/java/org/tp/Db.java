package org.tp;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Db {

    private Connection conn;
    public Db(String host, String port, String dbName, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public void close() {

    }

    public ResultSet getBoatByName(String name) {
        ArrayList<String> array = new ArrayList<String>();
        String sql = "Select * from bateau WHERE bateau.nom = ?";
        PreparedStatement stmt = null;
        ResultSet res = null;

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, name);
            res = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public ResultSet getTravelerBoatsWithEquipements(String name) {
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT bateau.*, voyageur.imageLink, GROUP_CONCAT(equipements.id, \",\", equipements.libelle SEPARATOR ':') AS equipements FROM equipements_voyageur, voyageur, bateau, equipements WHERE equipements_voyageur.id_voyageur = voyageur.codeBateau AND voyageur.codeBateau = bateau.codeBateau and equipements.id = equipements_voyageur.id_equipement and bateau.nom = ? GROUP BY bateau.nom";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet res = stmt.executeQuery();

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
