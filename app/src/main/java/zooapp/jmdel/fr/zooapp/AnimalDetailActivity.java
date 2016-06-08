package zooapp.jmdel.fr.zooapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;

import zooapp.jmdel.fr.zooapp.animal.AnimalManager;
import zooapp.jmdel.fr.zooapp.animal.model.Animal;

public class AnimalDetailActivity extends AppCompatActivity {

    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Bundle extra = getIntent().getExtras();
        animal = (Animal) extra.get("animal");

        ((TextView)(findViewById(R.id.animal_label_name))).setText("Nom : ");
        ((TextView)(findViewById(R.id.animal_detail_name))).setText(animal.getName());
        ((TextView)(findViewById(R.id.animal_label_specy))).setText("Espèce : ");
        ((TextView)(findViewById(R.id.animal_detail_specy))).setText(animal.getSpecy());
        ((TextView)(findViewById(R.id.animal_label_age))).setText("Age : ");
        String ageStr = ((Integer) (animal.getAge())).toString();
        ((TextView)(findViewById(R.id.animal_detail_age))).setText(ageStr);

        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.removebt);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AnimalManager.getInstance().removeAnimal(animal);
                    finish();
                }
            }) ;
        }
    }

    /*public void clickDeleteMethod(View view) {
        AnimalManager.getInstance().removeAnimal(animal);
        this.finish();
    }*/
}
