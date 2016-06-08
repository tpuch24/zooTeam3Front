package zooapp.jmdel.fr.zooapp.enclos.model;

import android.support.annotation.VisibleForTesting;

import java.io.Serializable;

/**
 * Created by hb on 07/06/2016.
 */
public class Enclos implements Serializable {
    private int id;
    private String nom;
    private int nbAnimal;
    private int nbAnimalMax;


    public Enclos(String nom, int nbAnimal, int nbAnimalMax) {
        this.nom = nom;
        this.nbAnimal = nbAnimal;
        this.nbAnimalMax = nbAnimalMax;
    }

    public Enclos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbAnimalMax() {
        return nbAnimalMax;
    }

    public void setNbAnimalMax(int nbAnimalMax) {
        this.nbAnimalMax = nbAnimalMax;
    }

    public int getNbAnimal() {
        return nbAnimal;
    }

    public void setNbAnimal(int nbAnimal) {
        this.nbAnimal = nbAnimal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdString() {
        return new Integer(this.getId()).toString();
    }

    public String getNbAnimalString() {
        return new Integer(this.getNbAnimal()).toString();
    }

    public boolean updateEnclos() {
        EnclosManager enclosM = EnclosManager.getInstance();
        return enclosM.updateEnclos(this);
    }

    public boolean addEnclos() {
        EnclosManager enclosM = EnclosManager.getInstance();
        return enclosM.addEnclos(this);
    }

    public boolean deleteEnclos() {
        EnclosManager enclosM = EnclosManager.getInstance();
        return enclosM.deleteEnclos(this);
    }
}
