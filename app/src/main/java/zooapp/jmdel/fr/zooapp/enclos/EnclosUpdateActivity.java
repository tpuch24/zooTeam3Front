package zooapp.jmdel.fr.zooapp.enclos;

import android.content.Intent;
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

public class EnclosUpdateActivity extends AppCompatActivity {
    private String idEnclos = new String();
    private String nom = new String();
    private String nbAnimaux = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_update);

        Bundle extra = getIntent().getExtras();
        idEnclos = extra.getString("idEnclos");
        nom = extra.getString("nom");
        nbAnimaux = extra.getString("nbAnimaux");

        ((TextView)findViewById(R.id.idEnclos)).setText(idEnclos);
        ((EditText)findViewById(R.id.nom)).setText(nom);
        ((EditText)findViewById(R.id.nbAnimaux)).setText(nbAnimaux);

        Spinner spinner = (Spinner) findViewById(R.id.type);
        EnclosManager.getInstance().initListeType();
        ArrayList<String> typeEnclos = EnclosManager.getInstance().getListeTypeEnclos();
        TypeEnclosAdapter typeEnclosAdapter = new TypeEnclosAdapter(this, typeEnclos);
        typeEnclosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(typeEnclosAdapter);
        spinner.getPrompt();

        FloatingActionButton cancelEnclos = (FloatingActionButton) findViewById(R.id.cancelEnclos);
        cancelEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EnclosUpdateActivity.this.finish();
                ((TextView)findViewById(R.id.idEnclos)).setText(idEnclos);
                ((EditText)findViewById(R.id.nom)).setText(nom);
                ((EditText)findViewById(R.id.nbAnimaux)).setText(nbAnimaux);
            }
        });

        FloatingActionButton saveEnclos = (FloatingActionButton) findViewById(R.id.saveEnclos);
        saveEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Modification d'enclos à coder", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
