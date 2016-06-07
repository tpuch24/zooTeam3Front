package zooapp.jmdel.fr.zooapp;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import zooapp.jmdel.fr.zooapp.model.Animal;
import zooapp.jmdel.fr.zooapp.model.AnimalManager;

public class AnimalNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_new);

        ((TextView)(findViewById(R.id.animal_new_label_name))).setText("Nom :");
        ((TextView)(findViewById(R.id.animal_new_label_specy))).setText("Espèce :");
        ((TextView)(findViewById(R.id.animal_new_label_age))).setText("Age :");

        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.addnewbt);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    String text = "Ajout d'un animal :";
                    int duration = Toast.LENGTH_SHORT;

                    String name =  ((EditText)(findViewById(R.id.animal_new_name))).getText().toString();
                    String specy =  ((EditText)(findViewById(R.id.animal_new_speci))).getText().toString();
                    String age = ((EditText)(findViewById(R.id.animal_new_age))).getText().toString();
                    text+= "Name: "+name+ " - specy: "+specy+" - age: "+ age;

                    Toast toast = Toast.makeText(context, (CharSequence) text, duration);
                    toast.show();

                    int ageint=0;
                    ageint = Integer.parseInt(age);

                    AnimalManager.getInstance().addNewAnimal(new Animal(ageint, specy, name));

                }
            }) ;
        }
    }
}
