package zooapp.jmdel.fr.zooapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Array;

import zooapp.jmdel.fr.zooapp.model.Animal;
import zooapp.jmdel.fr.zooapp.model.AnimalAdapter;
import zooapp.jmdel.fr.zooapp.model.AnimalManager;
import zooapp.jmdel.fr.zooapp.model.Food;
import zooapp.jmdel.fr.zooapp.model.FoodAdapter;
import zooapp.jmdel.fr.zooapp.model.FoodManager;

public class FoodActivity extends ListActivity {
    ArrayList<Food> foodlist = FoodManager.getInstance().getFoodList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);



        FoodAdapter foodAdapter = new FoodAdapter(this, foodlist);
        setListAdapter(foodAdapter);


        FloatingActionButton addfood = (FloatingActionButton) findViewById(R.id.add_food);
        addfood.setOnClickListener(new View.OnClickListener() {
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
        intent.putExtra("foodlist",foodlist.get(position).getName());
        startActivity(intent);

    }


}
