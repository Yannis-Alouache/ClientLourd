package org.tp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Window extends JFrame {
    private Container container;
    private Db db;

    public Window(Db db) {
        super();
        this.db = db;
        BoatSelection boatSelection = new BoatSelection(db);

        setSize(800, 600);
        setTitle("Client Lourd");

        JComboBox boatsList = boatSelection.getComboBox();

        JButton confirmBtn = new JButton();
        confirmBtn.setText("Confirmer");
        confirmBtn.setBackground(new Color(124,252,0));
        confirmBtn.addActionListener(new ConfirmBoatSelectionListener(boatsList, this.db));


        JTextArea textArea = new JTextArea();
        textArea.setColumns(55);
        textArea.setRows(5);

        JLabel textAreaLabel = new JLabel("Commentaire (facultatif)");
        textAreaLabel.setLabelFor(textArea);


        this.container = getContentPane();
        this.container.setLayout(new BorderLayout());
        this.container.add(boatsList, BorderLayout.NORTH);
        this.container.add(textArea, BorderLayout.EAST);
        this.container.add(textAreaLabel, BorderLayout.CENTER);
        this.container.add(confirmBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
