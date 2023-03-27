package org.tp;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoatSelection {

    private Db db;

    public BoatSelection(Db db) {
        this.db = db;
    }

    public JComboBox getComboBox() {
        JComboBox boatsList = new JComboBox();
        boatsList.addActionListener(new BoatSelectionListener(boatsList));
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
