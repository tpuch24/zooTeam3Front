package zooapp.jmdel.fr.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Enclos;

public class EnclosUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_update);

        Bundle extra = getIntent().getExtras();
        String idEnclos = extra.getString("idEnclos");
        String nom = (String) extra.get("nom");
        String nbAnimaux = (String) extra.get("nbAnimaux");

        ((TextView)findViewById(R.id.idEnclos)).setText(idEnclos);
        ((EditText)findViewById(R.id.nom)).setText(nom);
        ((EditText)findViewById(R.id.nbAnimaux)).setText(nbAnimaux);
    }
}
