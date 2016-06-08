package zooapp.jmdel.fr.zooapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import zooapp.jmdel.fr.zooapp.model.Food;
import zooapp.jmdel.fr.zooapp.model.FoodManager;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);


        FloatingActionButton food = (FloatingActionButton) findViewById(R.id.save_food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display a toast
                Context context = getApplicationContext();

                String text = "Name = " + ((TextView) (findViewById(R.id.EditTextName))).getText().toString() + "\n";
                text += "Type = " + ((Spinner) (findViewById(R.id.spinnerTypeeFood))).getSelectedItem().toString() + "\n";
                text += "Eater = " + ((TextView) (findViewById(R.id.EditTextEater))).getText().toString() + "\n";
                text += "Stock = " + ((TextView) (findViewById(R.id.EditDoubleStock))).getText().toString() + "\n";
                text += "Stock = " + ((TextView) (findViewById(R.id.EditStockUnit))).getText().toString();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                //Add to list
                Food foodToAdd = new Food(
                        ((TextView) (findViewById(R.id.EditTextName))).getText().toString(),
                        ((Spinner) (findViewById(R.id.spinnerTypeeFood))).getSelectedItem().toString(),
                        Double.valueOf(((TextView) (findViewById(R.id.EditDoubleStock))).getText().toString()),
                        ((TextView) (findViewById(R.id.EditStockUnit))).getText().toString(),
                        ((TextView) (findViewById(R.id.EditTextEater))).getText().toString()
                );
                FoodManager.getInstance().add_foodlist(foodToAdd);

                //show the list
                FloatingActionButton savefood = (FloatingActionButton) findViewById(R.id.save_food);
                savefood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FoodFormActivity.this, FoodActivity.class);
                        startActivity(intent);
                    }
                });

            };
        });
    }

}