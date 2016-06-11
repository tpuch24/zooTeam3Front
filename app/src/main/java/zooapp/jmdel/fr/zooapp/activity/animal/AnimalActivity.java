package zooapp.jmdel.fr.zooapp.activity.animal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.model.animal.Animal;
import zooapp.jmdel.fr.zooapp.model.animal.AnimalAdapter;
import zooapp.jmdel.fr.zooapp.model.animal.AnimalManager;

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
