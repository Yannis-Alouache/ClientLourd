package org.tp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoatSelectionListener implements ActionListener {

    private JComboBox comboBox;

    BoatSelectionListener(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.comboBox.getSelectedItem());
    }
}
