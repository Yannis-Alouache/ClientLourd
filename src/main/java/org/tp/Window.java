package org.tp;

import javax.swing.*;
import java.awt.*;

/**
 * A class used for handling window specifications
 */
public class Window extends JFrame {
    /**
     * The container is the canvas of the window where we can draw elements
     */
    private Container container;
    /**
     * The db instance that is used to communicate with database.
     */
    private Db db;

    /**
     * Handle the front-end and back-end of the window, use a Db object
     * It's the entry point of the application it calls all the class needed to make the software works
     *
     * @param db a valid Db object
     *
     */
    public Window(Db db) {
        super();
        this.db = db;
        BoatSelection boatSelection = new BoatSelection(db);

        setSize(800, 600);
        setTitle("Client Lourd");

        JComboBox boatsList = boatSelection.getComboBox();


        JTextArea textArea = new JTextArea();
        textArea.setColumns(55);
        textArea.setRows(5);

        JLabel textAreaLabel = new JLabel("Commentaire (facultatif)");
        textAreaLabel.setLabelFor(textArea);

        JButton confirmBtn = new JButton();
        confirmBtn.setText("Confirmer");
        confirmBtn.setBackground(new Color(124,252,0));
        confirmBtn.addActionListener(new ConfirmBoatSelectionListener(boatsList, this.db, textArea));


        this.container = getContentPane();
        this.container.setLayout(new BorderLayout());
        this.container.add(boatsList, BorderLayout.NORTH);
        this.container.add(textArea, BorderLayout.EAST);
        this.container.add(textAreaLabel, BorderLayout.CENTER);
        this.container.add(confirmBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
