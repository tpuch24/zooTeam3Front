package zooapp.jmdel.fr.zooapp.enclos.model;

import java.util.ArrayList;

/**
 * Created by hb on 07/06/2016.
 */
public class EnclosManager {
    private ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();
    private ArrayList<String> listeTypeEnclos = new ArrayList<String>();
    private static EnclosManager instEnclos;

    private EnclosManager() {
        super();
        initListe();
    }

    public static EnclosManager getInstance(){

        if (instEnclos==null){
            instEnclos = new EnclosManager();
        }
        return instEnclos;
    }

    protected void initListe(){
        Enclos enclos = new Enclos( "Enclos des lions", 3, 7, "Carnivores");
        enclos.setId(1);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos des oiseaux", 8, 12, "Oiseaux");
        enclos.setId(5);
        listeEnclos.add(enclos);
        enclos = new Enclos("Parc des reptiles", 40, 60, "Reptiles");
        enclos.setId(6);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos nord", 0, 10, "Mixte");
        listeEnclos.add(enclos);
        enclos.setId(9);
    }

    public void initListeType(){
        listeTypeEnclos.clear();
        String type = new String( "Carnivores");
        listeTypeEnclos.add(type);
        type = "Mixte";
        listeTypeEnclos.add(type);
        type = "Oiseaux";
        listeTypeEnclos.add(type);
        type = "Reptiles";
        listeTypeEnclos.add(type);
    }

    public ArrayList<Enclos> getListeEnclos(){
        return listeEnclos;
    }

    public ArrayList<String> getListeTypeEnclos(){
        return listeTypeEnclos;
    }

    public boolean updateEnclos(Enclos enclos) {
        return true;
    }

    public boolean addEnclos(Enclos enclos) {
        return true;
    }

    public boolean deleteEnclos(Enclos enclos) {
        return true;
    }

}
