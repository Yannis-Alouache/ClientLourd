package org.tp;

import java.util.ArrayList;
import java.util.Collection;

public class TravelerBoat extends Boat {

    private String imageLink;
    private Collection<Equipement> lesEquipements;

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

    public void print() {
        super.print();
        System.out.println("imageLink : " + imageLink);
        for (Equipement equipement: lesEquipements) {
            System.out.println(equipement.toString());
        }
    }
}
