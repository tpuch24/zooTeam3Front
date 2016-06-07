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

public class FoodActivity extends ListActivity {
    List <String> foodlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        foodlist.add("meat");
        foodlist.add("grains");
        foodlist.add("vegetables");
        foodlist.add("pop-korn");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.food_cell, R.id.food_name, foodlist);

        setListAdapter(adapter);

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
        intent.putExtra("s_food_name",foodlist.get(position));
        startActivity(intent);

    }


}
