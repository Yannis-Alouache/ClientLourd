package org.tp;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The listener that do all the logics of the pdf creation
 */
public class ConfirmBoatSelectionListener implements ActionListener {

    private JComboBox comboBox;
    private Db db;
    private JTextArea textArea;

    /**
     * Populate the ConfirmBoatSelectionListener Object
     *
     * @param comboBox the comboBox containing the boat names
     * @param db a valid Db objects
     * @param textArea a textArea objects used for additional comments
     *
     *
     */
    ConfirmBoatSelectionListener(JComboBox comboBox, Db db, JTextArea textArea) {
        this.comboBox = comboBox;
        this.db = db;
        this.textArea = textArea;
    }

    /**
     * Create a TravelerBoat from a sql request result
     * Can throw a SQLException
     *
     * @param res a valid ResultSet Objects containing the traveler boat data
     *
     * @return the newly created travelerBoat object
     */
    public TravelerBoat createBoatFromResultSet(ResultSet res) {
        TravelerBoat boat = null;

        try {
            res.next();
            String temp = res.getString(7);
            String[] equips = temp.split(":");
            boat = new TravelerBoat(
                    res.getInt(1),
                    res.getString(2),
                    res.getDouble(3),
                    res.getDouble(4),
                    res.getInt(5),
                    equips,
                    res.getString(6)
            );
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return boat;
    }

    /**
     * Populate the pdf document with all the boat informations
     * Can throw DocumentException
     *
     * @param boat the boat which the informations is taken
     * @param document the document you want to print informations on
     *
     */
    public void fillPdf(TravelerBoat boat, Document document) {
        try {
            document.add(new Paragraph(boat.getName(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 50)));
            document.add(ImageHandler.getImageFromUrl(boat.getImageLink(), document));
            document.add(new Paragraph(
                    "Longueur: " + String.valueOf(boat.getLongueur()) + " mètres",
                    FontFactory.getFont(FontFactory.HELVETICA, 16)
            ));
            document.add(new Paragraph(
                    "Largeur: " + String.valueOf(boat.getLargeur()) + " mètres",
                    FontFactory.getFont(FontFactory.HELVETICA, 16)
            ));
            document.add(new Paragraph(
                    "Vitesse: " + String.valueOf(boat.getVitesse()) + " noeuds",
                    FontFactory.getFont(FontFactory.HELVETICA, 16)
            ));

            document.add(new Paragraph(Chunk.NEWLINE));
            document.add(new Paragraph("Nos équipements :", FontFactory.getFont(FontFactory.HELVETICA, 16)));
            for (Equipement equipement : boat.getLesEquipements()) {
                document.add(new Paragraph(equipement.getLibelle(), FontFactory.getFont(FontFactory.HELVETICA, 16)));
            }

            if (textArea.getText() != null) {
                document.add(new Paragraph(Chunk.NEWLINE));
                document.add(new Paragraph("Commentaires : ", FontFactory.getFont(FontFactory.HELVETICA, 16)));
                document.add(new Paragraph(textArea.getText(), FontFactory.getFont(FontFactory.HELVETICA, 16)));
            }
        } catch (DocumentException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Create a connexion variable to the pdf file to send informations on
     *
     * @return the connexion variable to the pdf
     *
     */
    public OutputStream createOutputStream() {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("Brochure.pdf");
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return outputStream;
    }

    /**
     * Create a connexion between the document from iText lib and the pdf file to allow write on the file
     *
     * @param document a Document object
     * @param outputStream a OutputStream object
     *
     */
    public void createConnectionDocumentToFile(Document document, OutputStream outputStream) {
        try {
            PdfWriter.getInstance(document, outputStream);
        }
        catch (DocumentException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Do the pdf creation with the boat informations on click with the object it listen to
     * Can throw IOException
     *
     * @param e an actionEvent object
     *
     * @see ActionEvent
     * @see ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        ResultSet res = db.getTravelerBoatsWithEquipements(comboBox.getSelectedItem().toString());
        TravelerBoat boat = null;
        OutputStream outputStream = null;
        Document document = new Document();

        boat = createBoatFromResultSet(res);
        boat.print();
        System.out.println(textArea.getText());

        outputStream = createOutputStream();
        createConnectionDocumentToFile(document, outputStream);

        document.open();

        fillPdf(boat, document);

        document.close();
        try {
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
