package zooapp.jmdel.fr.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Enclos;

public class EnclosDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_detail);
        Bundle extra = getIntent().getExtras();
        Enclos enclo = new Enclos();
        enclo = (Enclos)extra.get("enclot");

        ((TextView)findViewById(R.id.idEnclos)).setText(enclo.getIdString());
        ((TextView)findViewById(R.id.nom)).setText(enclo.getNom());
        ((TextView)findViewById(R.id.nbAnimaux)).setText(enclo.getNbAnimalString());

    }
}
