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
        addMouseListener(new MouseAdapter());


        JComboBox boatsList = boatSelection.getComboList();




        this.container = getContentPane();
        this.container.setLayout(new FlowLayout());
        this.container.add(boatsList);



        setVisible(true);
    }
}
