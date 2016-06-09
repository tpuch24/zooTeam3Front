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
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;
import zooapp.jmdel.fr.zooapp.enclos.model.TypeEnclosAdapter;
import zooapp.jmdel.fr.zooapp.model.GenericArrayAdapter;

public class EnclosUpdateActivity extends AppCompatActivity {
    private Enclos enclos = new Enclos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_update);

        final Bundle extra = getIntent().getExtras();
        enclos = (Enclos)extra.get("Enclos");
        fillActivity(extra);

        FloatingActionButton cancelEnclos = (FloatingActionButton) findViewById(R.id.cancelEnclos);
        //Cancel
        cancelEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillActivity(extra);
            }
        });

        // Update
        FloatingActionButton saveEnclos = (FloatingActionButton) findViewById(R.id.saveEnclos);
        saveEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Appel du service d'update
                Enclos enclos = new Enclos();
                fillEnclos(enclos);
                if (enclos.updateEnclos()) {
                    Snackbar.make(view, "Modification bien effectuée", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(view,"La modification a échoué", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    private void fillActivity(Bundle extra) {

        ((TextView)findViewById(R.id.idEnclos)).setText(enclos.getIdString());
        ((EditText)findViewById(R.id.nom)).setText(enclos.getNom());
        ((EditText)findViewById(R.id.nbAnimaux)).setText(enclos.getNbAnimalString());

        Spinner spinner = (Spinner) findViewById(R.id.type);
        EnclosManager.getInstance().initListeType();
        ArrayList<String> typeEnclos = EnclosManager.getInstance().getListeTypeEnclos();
        TypeEnclosAdapter typeEnclosAdapter = new TypeEnclosAdapter(this, typeEnclos);
        typeEnclosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(typeEnclosAdapter);
        // Positionnement sur la bonne valeur
        for (int i =0; i<spinner.getCount();i++ ) {
            if (spinner.getItemAtPosition(i).equals(enclos.getType())) {
                spinner.setSelection(i);
                break;
            }
        }
    }

    private void fillEnclos(Enclos enclos) {
        enclos.setIdString((String)((TextView)findViewById(R.id.idEnclos)).getText());
        enclos.setNbAnimalString( ((EditText)findViewById(R.id.nbAnimaux)).getText().toString());
        enclos.setNom( ((EditText)findViewById(R.id.nom)).getText().toString());
        enclos.setType(((Spinner)findViewById(R.id.type)).getSelectedItem().toString());
    }
}
