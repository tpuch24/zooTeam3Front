package zooapp.jmdel.fr.zooapp;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Food;
import zooapp.jmdel.fr.zooapp.model.FoodManager;

public class FoodDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Bundle extra = getIntent().getExtras();
        final Food food = (Food) extra.getSerializable("food");
        String content = "Name :  " + food.getName() + " \n" +
                "Type :  " + food.getType() + " \n " +
                "Eater : " + food.getEater_type() + " \n " +
                "Stock : " + food.getStock() + " " + food.getUnity();

        ((TextView) (findViewById(R.id.food_detail_text))).setText(content);

        FloatingActionButton suppr_food = (FloatingActionButton) findViewById(R.id.suppr_food);
        suppr_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display a toast
                Context context = getApplicationContext();
                FoodManager.getInstance().suppr_foodlist(food);

            }

            ;
        });
    }

}
