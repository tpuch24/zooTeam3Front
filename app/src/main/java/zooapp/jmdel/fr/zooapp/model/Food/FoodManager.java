package zooapp.jmdel.fr.zooapp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jean-michel on 07/06/2016.
 */
public class FoodManager {

    protected ArrayList<Food> liste = new ArrayList<Food>();

    protected static FoodManager instance;

    private FoodManager() {
        super();
       // initListe();
    }

    public static FoodManager getInstance() {

        if (instance == null) {
            instance = new FoodManager();
        }
        return instance;
    }
    /*
    protected void initListe() {
        Food food = new Food("Mouse", "Animal alive", 20.0, "u", "Reptiles");
        liste.add(food);
        food = new Food("Carcasse", "Meat", 50.0, "kg", "Fauves");
        liste.add(food);
        food = new Food("Tournesol", "Grains", 30.0, "kg", "Birds");
        liste.add(food);
        food = new Food("Salade", "Vegetables", 10.0, "kg", "Turtle");
        liste.add(food);
    }
*/
    public void add_foodlist(Food foodToAdd) {

        for (Food foodItem : liste) {
            String foodItemName = foodItem.getName();
            String foodToAddName = foodToAdd.getName();

            if (foodItemName.equals(foodToAddName)) {
                //exist
                return;
            }
        }
        //only excuted if not exists
        liste.add(foodToAdd);

    }

    public void suppr_foodlist(Food foodToSuppr) {

        for (Food foodItem : liste) {
            String foodItemName = foodItem.getName();
            String foodToSupprName = foodToSuppr.getName();
            if (foodItemName.equals(foodToSupprName)) {
                liste.remove(foodItem);
            }
        }
    }

    public void update_foodlist(Food foodToUpdate) {
        int index = 0;
        for (Food foodItem : liste) {
            String foodItemName = foodItem.getName();
            String foodToUpdateName = foodToUpdate.getName();
            if (foodItemName.equals(foodToUpdateName)) {
                liste.set(index, foodToUpdate);
            }
            index++;
        }
    }

    public Food find_by_foodname(String foodName) {

        for (Food foodItem : liste) {
            if (foodItem.getName().equals(foodName)) {
                return (foodItem);
            }
        }
        return (null);

    }

    public ArrayList<Food> getFoodList() {
        if(true) {
            FoodSyncService myFoodSync = new FoodSyncService();
            liste = (ArrayList)myFoodSync.startSyncLocalFoodAction();
        }
        return liste;
    }
}
