package org.tp;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Db db = new Db("localhost", "3306", "mariebdd", "root", "");
        Window window = new Window(db);



    }
}
