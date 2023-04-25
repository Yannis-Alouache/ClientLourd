package org.tp;

import java.sql.SQLException;

/**
 * Main class that call db and launch the window
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Db db = new Db("localhost", "3306", "mariebdd", "root", "");
        Window window = new Window(db);
    }
}
