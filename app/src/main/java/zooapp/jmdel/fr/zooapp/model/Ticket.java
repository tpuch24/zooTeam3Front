package zooapp.jmdel.fr.zooapp.model;

import java.util.List;

/**
 * Created by User on 07/06/2016.
 */
public class Ticket {
    String nom;
    String prenom;
    String date;
    Boolean groupe;
    int tarif;

    public Ticket(String visiteur, String s, String s1, boolean b, int tarif) {
        setNom(visiteur);
        setPrenom(s);
        setDate(s1);
        setGroupe(b);
        setTarif(tarif);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getGroupe() {
        return groupe;
    }

    public void setGroupe(Boolean groupe) {
        this.groupe = groupe;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
}
