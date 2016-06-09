package zooapp.jmdel.fr.zooapp.enclos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;
import zooapp.jmdel.fr.zooapp.enclos.model.TypeEnclosAdapter;

public class EnclosAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_add);

        fillActivity();

        //Cancel
        FloatingActionButton cancelEnclos = (FloatingActionButton) findViewById(R.id.cancelEnclos);
        cancelEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
fillActivity();            }
        });

        // Insert
        FloatingActionButton saveEnclos = (FloatingActionButton) findViewById(R.id.saveEnclos);
        saveEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Appel du service d'insertion
                // Fermeture de l'activity et appel de l'activity de détail
                // Avec l'enregistrement en cours
                Snackbar.make(view, "Ajout d'enclos à coder", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void fillActivity() {

        ((TextView)findViewById(R.id.idEnclos)).setText("");
        ((EditText)findViewById(R.id.nom)).setText("");
        ((EditText)findViewById(R.id.nbAnimaux)).setText("");

        Spinner spinner = (Spinner) findViewById(R.id.type);
        EnclosManager.getInstance().initListeType();
        ArrayList<String> typeEnclos = EnclosManager.getInstance().getListeTypeEnclos();
        TypeEnclosAdapter typeEnclosAdapter = new TypeEnclosAdapter(this, typeEnclos);
        typeEnclosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(typeEnclosAdapter);
        // Positionnement sur la bonne valeur
    }

}
