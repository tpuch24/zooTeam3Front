package zooapp.jmdel.fr.zooapp.model.animal;

import java.util.ArrayList;

/**
 * Created by Thierry on 06/06/2016.
 */
public class AnimalManager {

    protected ArrayList<Animal> liste = new ArrayList<Animal>();
    protected static AnimalManager instance;

    private AnimalManager(){
        super();
        initListe();
    }

    public static AnimalManager getInstance(){

        if (instance==null){
            instance = new AnimalManager();
        }
        return instance;
    }

    protected void initListe(){
    Animal animal = new Animal(3,"Tigre","Tigrou");
        liste.add(animal);
        animal = new Animal(2,"Ours","Balou");
        liste.add(animal);
        animal = new Animal(5,"Panthère","Baghera");
        liste.add(animal);
        animal = new Animal(4,"Serpent","Zaar");
        liste.add(animal);
    }

    public ArrayList<Animal> getListeAnimal(){
        return liste;
    }
}

