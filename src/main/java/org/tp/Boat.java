package org.tp;

public class Boat {
    private Integer id;
    private String name;
    private double longueur;
    private double largeur;
    private int vitesse;

    public Boat(Integer id, String name, double longueur, double largeur, int vitesse) {
        this.id = id;
        this.name = name;
        this.longueur = longueur;
        this.largeur = largeur;
        this.vitesse = vitesse;
    }

    public void print() {
        System.out.println("id :" + this.id);
        System.out.println("name :" + this.name);
        System.out.println("longueur :" + this.longueur);
        System.out.println("largeur :" + this.largeur);
        System.out.println("vitesse :" + this.vitesse);
    }
}
