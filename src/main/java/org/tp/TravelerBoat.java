package org.tp;


import java.util.ArrayList;
import java.util.Collection;

/**
 * This class is used as storage for TravelerBoat information gotten from database to make easy the process of manipulating boat
 */
public class TravelerBoat extends Boat {

    private String imageLink;
    private Collection<Equipement> lesEquipements;

    /**
     * Populate the travelerBoat objects variable
     * travelerBoat is a child of the boat class
     * the object got an array of equipements and an imageLink in addition of the boat class
     *
     * @param  id identifier of the boat
     * @param  name the boat name
     * @param  longueur the boat longueur in meter
     * @param  largeur the boat largeur in meter
     * @param  vitesse the boat speed in node
     * @param equipements the list of the equipements names
     * @param imageLink a image url
     */
    public TravelerBoat(Integer id,
                        String name,
                        double longueur,
                        double largeur,
                        int vitesse,
                        String[] equipements,
                        String imageLink
    ) {
        super(id, name, longueur, largeur, vitesse);
        this.imageLink = imageLink;
        this.lesEquipements = new ArrayList<>();

        for (String equipement : equipements) {
            String[] equipementElements = equipement.split(",");
            lesEquipements.add(new Equipement(equipementElements[0], equipementElements[1]));
        }
    }

    /**
     * Print on the console the boat informations
     *
     */
    public void print() {
        super.print();
        System.out.println("imageLink : " + imageLink);
        for (Equipement equipement: lesEquipements) {
            System.out.println(equipement.toString());
        }
    }

    /**
     * get the imageLink of the boat
     *
     * @return the imageLink of the boat
     *
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * get the collection of equipements of the boats
     *
     * @return the collection of equipements of the boats
     *
     */
    public Collection<Equipement> getLesEquipements() {
        return lesEquipements;
    }
}
