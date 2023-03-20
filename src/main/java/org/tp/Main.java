package org.tp;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Db db = new Db("localhost", "3306", "mariebdd", "root", "");
        ResultSet boats = db.getTravelerBoatsWithEquipements();
        Window window = new Window(db);
        db.getBoatsName();



//        while (boats.next()) {
//            // retrieve and print the values for the current row
//            int i = boats.getInt("codeBateau");
//            String s = boats.getString("nom");
//            int f = boats.getInt("longueur");
//            int g = boats.getInt("largeur");
//            int h = boats.getInt("vitesse");
//            String z = boats.getString("imageLink");
//            String y = boats.getString("equipements");
//            System.out.println("ROW = " + i + " " + s + " " + f + " " + g + " " + h + " " + z + " " + y);
//        }

    }
}
