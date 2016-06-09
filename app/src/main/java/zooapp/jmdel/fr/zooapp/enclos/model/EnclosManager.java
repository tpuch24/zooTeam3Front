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
    //    initListe();
    }

    public static EnclosManager getInstance(){

        if (instEnclos==null){
            instEnclos = new EnclosManager();
        }
        return instEnclos;
    }

    private void initListe(){
        listeEnclos.clear();
        Enclos enclos = new Enclos( "Enclos des lions", 3, 7, "Cage");
        enclos.setId(1);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos des oiseaux", 8, 12, "Volière");
        enclos.setId(5);
        listeEnclos.add(enclos);
        enclos = new Enclos("Parc des reptiles", 40, 60, "Vivarium");
        enclos.setId(6);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos nord", 0, 10, "Enclos");
        listeEnclos.add(enclos);
        enclos.setId(9);
    }

    private void initListeType(){
        listeTypeEnclos.clear();
        String type = new String("Cage");
        listeTypeEnclos.add(type);
        type = "Enclos";
        listeTypeEnclos.add(type);
        type = "Vivarium";
        listeTypeEnclos.add(type);
        type = "Volière";
        listeTypeEnclos.add(type);
    }

    public ArrayList<Enclos> getListeEnclos(){
        initListe();
        return listeEnclos;
    }

    public ArrayList<String> getListeTypeEnclos(){
        initListeType();
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

    public Enclos getEnclos(Enclos enclos) {
        return enclos;
    }

}
