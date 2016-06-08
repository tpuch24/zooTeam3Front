package zooapp.jmdel.fr.zooapp.model;

import java.util.ArrayList;

/**
 * Created by jean-michel on 07/06/2016.
 */
public class FoodManager {
    protected ArrayList<Food> liste = new ArrayList<Food>();
    protected static FoodManager instance;

    private FoodManager(){
        super();
        initListe();
    }

    public static FoodManager getInstance(){

        if (instance==null){
            instance = new FoodManager();
        }
        return instance;
    }

    protected void initListe(){
        Food food = new Food("Mouse","Animal alive",20.0,"u","Reptiles");
        liste.add(food);
        food = new Food("Carcasse","Meat",50.0,"kg","Fauves");
        liste.add(food);
        food = new Food("Tournesol","Grains",30.0,"kg","Birds");
        liste.add(food);
        food = new Food("Salade","Vegetables",10.0,"kg","Turtle");
        liste.add(food);
    }

    public void add_foodlist(Food foodToAdd){

        for(Food foodItem : liste) {
            if(foodItem.getName().equals(foodToAdd.getName())){
                //exist
                return;
            }
        }
        //only excuted if not exists
        liste.add(foodToAdd);

    }
    public void suppr_foodlist(Food foodToSuppr){

        for(Food foodItem : liste) {
            if(foodItem.getName().equals(foodToSuppr.getName())){
                liste.remove(foodItem);

            }
        }
    }

    public void update_foodlist(Food foodToUpdate){

        for(Food foodItem : liste) {
            if(foodItem.getName().equals(foodToUpdate.getName())){
                liste.remove(foodItem);
                liste.add(foodToUpdate);

            }
        }
    }

    public ArrayList<Food> getFoodList(){
        return liste;
    }
}
