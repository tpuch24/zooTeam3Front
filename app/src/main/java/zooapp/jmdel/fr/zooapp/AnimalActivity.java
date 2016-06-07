package zooapp.jmdel.fr.zooapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import zooapp.jmdel.fr.zooapp.model.Animal;
import zooapp.jmdel.fr.zooapp.model.AnimalAdapter;
import zooapp.jmdel.fr.zooapp.model.AnimalManager;

public class AnimalActivity extends ListActivity {

    ArrayList<Animal> animals = AnimalManager.getInstance().getListeAnimal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

       /* for (Animal animal: animals) {
            animallist.add(animal.getName());
        }
        */
        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
        setListAdapter(animalAdapter);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        R.layout.animal_cell, R.id.animal_name, animals);

        setListAdapter(animalAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this,AnimalDetailActivity.class);
        intent.putExtra("s_animal_name",animals.get(position).getName());
        startActivity(intent);

    }
}
