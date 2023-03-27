package org.tp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmBoatSelectionListener implements ActionListener {

    private JComboBox comboBox;
    private Db db;

    ConfirmBoatSelectionListener(JComboBox comboBox, Db db) {
        this.comboBox = comboBox;
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        ResultSet res = db.getTravelerBoatsWithEquipements(comboBox.getSelectedItem().toString());

        try {
            res.next();
            int id = res.getInt(1);
            String name = res.getString(2);
            double longueur = res.getDouble(3);
            double largeur = res.getDouble(4);
            int vitesse = res.getInt(5);
            String imageLink = res.getString(6);

            String temp = res.getString(7);
            String[] equips = temp.split(":");


            TravelerBoat boat = new TravelerBoat(id, name, longueur, largeur, vitesse, equips, imageLink);
            boat.print();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
}
