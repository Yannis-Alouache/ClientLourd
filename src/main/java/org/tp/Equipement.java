package org.tp;

public class Equipement {
    private String id;
    private String libelle;

    public Equipement(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
