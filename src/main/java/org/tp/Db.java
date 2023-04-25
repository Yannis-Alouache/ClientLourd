package org.tp;
import java.sql.*;
import java.util.ArrayList;
import static java.lang.System.exit;

/**
 * A service class used to get data from a database
 */
public class Db {

    private Connection conn;

    /**
     * Generate the connexion variable to access database data
     * If the database informations are not valid or the JDBC class is not found an exception is thrown
     *
     * @param  host the ip on which the database is hosted
     * @param  port the port that is open for the database
     * @param  dbName the database name
     * @param  user the database username
     * @param  password the database password related to the user
     * @see         SQLException
     * @see         ClassNotFoundException
     * @see         DriverManager
     */
    public Db(String host, String port, String dbName, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    /**
     * Returns a boat from a given name
     * Can throw an SQL exception
     *
     * @param  name the boat name to find
     * @return      the boat with the specified name
     * @see         SQLException
     */
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

    /**
     * Returns a boat from a given name with its equipements and Image URL
     * Can throw an SQL exception
     *
     * @param  name the boat name to find
     * @return      the boat with the specified name
     * @see         SQLException
     */
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

    /**
     * Returns all boats names
     * Can throw an SQL exception
     *
     * @return      a list of all boat names
     * @see         SQLException
     */
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
