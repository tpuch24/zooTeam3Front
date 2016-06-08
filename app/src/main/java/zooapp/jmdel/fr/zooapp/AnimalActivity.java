package zooapp.jmdel.fr.zooapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.animal.model.Animal;
import zooapp.jmdel.fr.zooapp.animal.AnimalAdapter;
import zooapp.jmdel.fr.zooapp.animal.AnimalManager;

/**
 * Activity to show Animal list to be selected
 */
public class AnimalActivity extends ListActivity {

    ArrayList<Animal> animals = AnimalManager.getInstance().getListeAnimal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
        setListAdapter(animalAdapter);


        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.addbt);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Appel à ajout d'un animal";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent = new Intent(AnimalActivity.this,AnimalNewActivity.class);
                startActivity(intent);
            }
        }) ;

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this,AnimalDetailActivity.class);
        intent.putExtra("animal",animals.get(position));
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        animals = AnimalManager.getInstance().getListeAnimal();
        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
        setListAdapter(animalAdapter);
    }
}
