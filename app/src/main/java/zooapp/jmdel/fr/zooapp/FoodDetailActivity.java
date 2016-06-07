package zooapp.jmdel.fr.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Food;

public class FoodDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Bundle extra = getIntent().getExtras();
        Food food = (Food) extra.getSerializable("food");

        ((TextView)(findViewById(R.id.food_detail_text))).setText(
                "Name :  "+food.getName()+" \n"+
                "Type :  "+food.getType()+" \n "+
                "Eater : "+food.getEater_type()+" \n "+
                "Stock : "+food.getStock()+" "+ food.getUnity()
        );
    }

}
