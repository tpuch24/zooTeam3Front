package zooapp.jmdel.fr.zooapp.animal;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.animal.model.Animal;

public class AnimalUpdateActivity extends AppCompatActivity {

    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_update);

        Bundle extra = getIntent().getExtras();
        animal = (Animal) extra.get("animal");

        ((TextView)(findViewById(R.id.animal_label_updt_name))).setText("Nom : ");
        ((TextView)(findViewById(R.id.animal_updt_name))).setText(animal.getName());
        ((TextView)(findViewById(R.id.animal_label_updt_specy))).setText("Espèce : ");
        ((TextView)(findViewById(R.id.animal_updt_specy))).setText(animal.getSpecy());
        ((TextView)(findViewById(R.id.animal_label_upd_age))).setText("Age : ");
        String ageStr = ((Integer) (animal.getAge())).toString();
        ((TextView)(findViewById(R.id.animal_upd_age))).setText(ageStr);

        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.updatebt);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String name =  ((EditText)(findViewById(R.id.animal_updt_name))).getText().toString();
                    String specy =  ((EditText)(findViewById(R.id.animal_updt_specy))).getText().toString();
                    String age = ((EditText)(findViewById(R.id.animal_upd_age))).getText().toString();

                    int ageint=0;
                    ageint = Integer.parseInt(age);

                    AnimalManager.getInstance().updateAnimal(animal, new Animal(ageint, specy, name));

                    finish();
                }
            }) ;
        }
    }

}
