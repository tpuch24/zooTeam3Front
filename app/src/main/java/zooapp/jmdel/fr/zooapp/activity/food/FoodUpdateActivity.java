package zooapp.jmdel.fr.zooapp.activity.food;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.model.Food.Food;
import zooapp.jmdel.fr.zooapp.model.Food.FoodManager;

public class FoodUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_update);

        Bundle extra = getIntent().getExtras();
        final Food food = (Food) extra.getSerializable("food");

        // Edit values from object food to fields
        //non-modifialble Food Name
            ((TextView)findViewById(R.id.FixedFoodName)).setText(food.getName())  ;
        //Spiner type
        Spinner mySpinner = (Spinner)findViewById(R.id.spinnerTypeeFood);
        int index = 0;
        for (int i=0;i<mySpinner.getCount();i++){
            if (mySpinner.getItemAtPosition(i).equals(food.getType())){
                mySpinner.setSelection(i);
                break;
            }
        }
        //EditText eater, stock, unity
        ((EditText)findViewById(R.id.EditTextEater)).setText(food.getEater_type());
        ((EditText)findViewById(R.id.EditDoubleStock)).setText(String.valueOf(food.getStock()));
        ((EditText)findViewById(R.id.EditStockUnit)).setText(food.getUnity());

        // On click update-food_bt
        FloatingActionButton food_update_btn = (FloatingActionButton) findViewById(R.id.update_food_bt);
        food_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                //display a toast
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, "Enregistrement en cours", duration);
                toast.show();

                //Update in list
                Food foodToUpdate = new Food(
                        ((TextView) (findViewById(R.id.FixedFoodName))).getText().toString(),
                        ((Spinner) (findViewById(R.id.spinnerTypeeFood))).getSelectedItem().toString(),
                        Double.valueOf(((TextView) (findViewById(R.id.EditDoubleStock))).getText().toString()),
                        ((TextView) (findViewById(R.id.EditStockUnit))).getText().toString(),
                        ((TextView) (findViewById(R.id.EditTextEater))).getText().toString()
                );
                FoodManager.getInstance().update_foodlist(foodToUpdate);
                finish();
            };
        });
    }
}
