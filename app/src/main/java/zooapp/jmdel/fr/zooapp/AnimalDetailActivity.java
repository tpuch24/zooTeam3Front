package zooapp.jmdel.fr.zooapp;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import zooapp.jmdel.fr.zooapp.model.Animal;

public class AnimalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Bundle extra = getIntent().getExtras();
        Animal animal = (Animal) extra.get("animal");

        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.removebt);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    CharSequence text = "Suppression d'un animal";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            }) ;
        }

        ((TextView)(findViewById(R.id.animal_label_name))).setText("Nom :");
        ((TextView)(findViewById(R.id.animal_detail_name))).setText(animal.getName()+" - Specy: "+animal.getSpecy()+" - Age : "+animal.getAge()+" year");
    }
}
