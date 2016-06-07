package zooapp.jmdel.fr.zooapp.model;

import java.util.ArrayList;

/**
 * Created by hb on 07/06/2016.
 */
public class EnclosManager {
    private ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();
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
        Enclos enclos = new Enclos( "Enclos des lions", 3, 7);
        enclos.setId(1);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos des oiseaux", 8, 12);
        enclos.setId(5);
        listeEnclos.add(enclos);
        enclos = new Enclos("Parc des reptiles", 40, 60);
        enclos.setId(6);
        listeEnclos.add(enclos);
        enclos = new Enclos("Enclos nord", 0, 10);
        listeEnclos.add(enclos);
        enclos.setId(9);
    }

    public ArrayList<Enclos> getListeAnimal(){
        return listeEnclos;
    }

}
