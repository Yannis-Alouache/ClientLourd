package org.tp;

/**
 * A class that handle the storage of the equipements of a travelerBoat
 */
public class Equipement {
    private String id;
    private String libelle;

    /**
     * Populate the variables of the equipement object
     *
     * @param  id identifier of the equipement
     * @param  libelle the text that applies to the equipement
     */
    public Equipement(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }


    /**
     * get the equipement data
     *
     * @return the equipement data
     *
     */
    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    /**
     * get the libelle of the equipement
     *
     * @return the equipement libelle
     *
     */
    public String getLibelle() {
        return libelle;
    }
}
