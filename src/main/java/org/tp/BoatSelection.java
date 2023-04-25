package org.tp;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BoatSelection is a simple select list (ComboBox) that contain all boats
 */
public class BoatSelection {

    private Db db;

    /**
     * Give access to the database to BoatSelection
     *
     * @param  db a Db object
     */
    public BoatSelection(Db db) {
        this.db = db;
    }

    /**
     * Get the comboBox filled with all boat names
     * Can throw a SQLException
     *
     * @return A comboBox filled with all boat names
     */
    public JComboBox getComboBox() {
        JComboBox boatsList = new JComboBox();
        ResultSet boatsName = this.db.getBoatsName();

        try {
            while (boatsName.next()) {
                boatsList.addItem(boatsName.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boatsList;
    }
}
