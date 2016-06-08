package zooapp.jmdel.fr.zooapp.animal;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.animal.model.Animal;

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

    /**
     *
     * @return all animal's list
     */
    public ArrayList<Animal> getListeAnimal(){
        return liste;
    }

    /**
     *
     * @param name
     * @return  animal who have "name" - null if notexist
     */
    public Animal getAnimalByName(String name){
        for (Animal animal: liste  ) {
            if (animal.getName() == name) { return animal;}
        }
        return null;
    }

    /**
     * Add an animal in list - Birth or new arrival
     * @param animal
     */
    public void addNewAnimal(Animal animal){
        for (Animal animalExist: liste  ) {

            if (animalExist.getName() == animal.getName()) { return;}
        }
        liste.add(animal);
    }

    /**
     * remove animal from list
     * @param animal
     */
    public void removeAnimal(Animal animal){

        //Context context = getApplicationContext();

        for (Animal animalExist: liste  ) {
            if (animalExist.getName().compareTo(animal.getName()) == 0) {
                liste.remove(animalExist);
              return;
            }
        }
    }


    public void updateAnimal(Animal animal){
        for (Animal animalExist: this.liste  ) {
            if (animalExist.getName() == animal.getName()) {
                liste.remove(animalExist);
                liste.add(animal);
            }
        }
        liste.add(animal);
    }
}

