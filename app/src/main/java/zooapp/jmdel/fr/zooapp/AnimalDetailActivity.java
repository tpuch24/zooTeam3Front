package zooapp.jmdel.fr.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnimalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Bundle extra = getIntent().getExtras();
        String animal_name = extra.getString("s_animal_name");

        ((TextView)(findViewById(R.id.animal_detail_name))).setText(animal_name);
    }
}
