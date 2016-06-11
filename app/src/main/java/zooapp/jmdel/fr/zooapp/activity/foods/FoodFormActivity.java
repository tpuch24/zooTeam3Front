package zooapp.jmdel.fr.zooapp.activity.foods;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.model.Food.Food;
import zooapp.jmdel.fr.zooapp.model.Food.FoodManager;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);


        FloatingActionButton food = (FloatingActionButton) findViewById(R.id.save_food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String food_name = ((TextView) (findViewById(R.id.EditTextName))).getText().toString();
                    String food_type = ((Spinner) (findViewById(R.id.spinnerTypeeFood))).getSelectedItem().toString();
                    String food_eater = ((TextView) (findViewById(R.id.EditTextEater))).getText().toString();
                    String food_qantity_str = ((TextView) (findViewById(R.id.EditDoubleStock))).getText().toString();
                    String food_unity = ((TextView) (findViewById(R.id.EditStockUnit))).getText().toString();
                    //display a toast
                    Context context = getApplicationContext();

                    String text = "Name = " + food_name + "\n";
                    text += "Type = " + food_type + "\n";
                    text += "Eater = " + food_eater + "\n";
                    text += "Stock = " + food_qantity_str + " " + food_unity + "\n";

                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    //Add to list
                    Food foodToAdd = new Food(
                            food_name,
                            food_type,
                            Double.valueOf(food_qantity_str),
                            food_unity,
                            food_eater
                    );
                    FoodManager.getInstance().add_foodlist(foodToAdd);
                    finish();
                } catch (Exception e) {
                    throw e;
                }
            }
        });
    }
}