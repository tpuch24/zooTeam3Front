package zooapp.jmdel.fr.zooapp.activity.foods;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.model.Food.Food;
import zooapp.jmdel.fr.zooapp.model.Food.FoodAdapter;
import zooapp.jmdel.fr.zooapp.model.Food.FoodManager;

public class FoodActivity extends ListActivity {
    ArrayList<Food> foodlist = FoodManager.getInstance().getFoodList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);



        FoodAdapter foodAdapter = new FoodAdapter(this, foodlist);
        setListAdapter(foodAdapter);
/*
        ((TextView) (findViewById(R.id.food_detail_name))).setText(food.getName().toString());
        ((TextView) (findViewById(R.id.food_detail_type))).setText(food.getType().toString());
*/
        FloatingActionButton add_food = (FloatingActionButton) findViewById(R.id.add_food);
        add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FoodActivity.this,FoodFormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this,FoodDetailActivity.class);
        intent.putExtra("food",foodlist.get(position));
        startActivity(intent);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        foodlist = FoodManager.getInstance().getFoodList();
        FoodAdapter foodAdapter = new FoodAdapter(this, foodlist);
        setListAdapter(foodAdapter);

    }

}
