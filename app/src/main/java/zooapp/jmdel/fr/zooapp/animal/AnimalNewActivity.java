package zooapp.jmdel.fr.zooapp.animal;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.animal.model.Animal;
import zooapp.jmdel.fr.zooapp.animal.AnimalManager;

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

                    String name =  ((EditText)(findViewById(R.id.animal_new_name))).getText().toString();
                    String specy =  ((EditText)(findViewById(R.id.animal_new_speci))).getText().toString();
                    String age = ((EditText)(findViewById(R.id.animal_new_age))).getText().toString();

                    Context context = getApplicationContext();
                    String text = "Danger: "+"name: "+name+" - specy: "+specy+" - age: "+age;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, (CharSequence) text, duration);
                    toast.show();

                    if ((name == "" ) || (name == null ) || (specy =="") || (specy == null) || (age == null)){
                         context = getApplicationContext();
                         text = "Tous les champs sont obligatoires !!!";
                         duration = Toast.LENGTH_SHORT;
                         toast = Toast.makeText(context, (CharSequence) text, duration);
                        toast.show();
                        return;
                    }
                    else {
                        int ageint = 0;
                        ageint = Integer.parseInt(age);

                        AnimalManager.getInstance().addNewAnimal(new Animal(ageint, specy, name));
                        finish();
                    }
                }
            }) ;
        }
    }
}
