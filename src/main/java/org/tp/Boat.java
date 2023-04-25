package org.tp;

/**
 * The boat class is used as the mother for TravelerBoat class.
 */
public class Boat {
    private Integer id;
    private String name;
    private double longueur;
    private double largeur;
    private int vitesse;

    /**
     * Populate the variables of the boat object
     *
     * @param  id identifier of the boat
     * @param  name the boat name
     * @param  longueur the boat longueur in meter
     * @param  largeur the boat largeur in meter
     * @param  vitesse the boat speed in node
     */
    public Boat(Integer id, String name, double longueur, double largeur, int vitesse) {
        this.id = id;
        this.name = name;
        this.longueur = longueur;
        this.largeur = largeur;
        this.vitesse = vitesse;
    }

    /**
     * Print in the console the boat informations
     *
     */
    public void print() {
        System.out.println("id :" + this.id);
        System.out.println("name :" + this.name);
        System.out.println("longueur :" + this.longueur);
        System.out.println("largeur :" + this.largeur);
        System.out.println("vitesse :" + this.vitesse);
    }
    /**
     * Get the boat largeur
     *
     * @return      The boat largeur
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * Get the boat longueur
     *
     * @return      The boat longueur
     */
    public double getLongueur() {
        return longueur;
    }

    /**
     * Get the boat id
     *
     * @return      The boat identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Get the boat speed
     *
     * @return      The boat speed
     */
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Get the boat name
     *
     * @return      The boat name
     */
    public String getName() {
        return name;
    }
}
