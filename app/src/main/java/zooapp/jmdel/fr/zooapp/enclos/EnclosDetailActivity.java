package zooapp.jmdel.fr.zooapp.enclos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosAdapter;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;
import zooapp.jmdel.fr.zooapp.enclos.model.TypeEnclosAdapter;

public class EnclosDetailActivity extends AppCompatActivity {

    private Enclos enclo = new Enclos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_detail);
        Bundle extra = getIntent().getExtras();
        enclo = (Enclos)extra.get("enclot");

        ((TextView)findViewById(R.id.idEnclos)).setText(enclo.getIdString());
        ((TextView)findViewById(R.id.nom)).setText(enclo.getNom());
        ((TextView)findViewById(R.id.nbAnimaux)).setText(enclo.getNbAnimalString());
        ((TextView)findViewById(R.id.type)).setText(enclo.getType());


        FloatingActionButton updateEnclos = (FloatingActionButton) findViewById(R.id.updateEnclos);
        updateEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnclosDetailActivity.this,EnclosUpdateActivity.class);
                String idEnclos = (String) ((TextView)findViewById(R.id.idEnclos)).getText();
                String nom = (String) ((TextView)findViewById(R.id.nom)).getText();
                String nbAnimaux = (String) ((TextView)findViewById(R.id.nbAnimaux)).getText();

                intent.putExtra("idEnclos",idEnclos);
                intent.putExtra("nom",nom);
                intent.putExtra("nbAnimaux",nbAnimaux);
                startActivity(intent);
            }
        });

        FloatingActionButton newEnclos = (FloatingActionButton) findViewById(R.id.newEnclos);
        newEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnclosDetailActivity.this,EnclosAddActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton deleteEnclos = (FloatingActionButton) findViewById(R.id.deleteEnclos);
        assert deleteEnclos != null;
        deleteEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enclo.deleteEnclos() == true) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Supression effectuée", Toast.LENGTH_SHORT);
                    toast.show();
     //               Snackbar.make(view, "Suppression effectuée", Snackbar.LENGTH_LONG)
     //                       .setAction("Action", null).show();
                    EnclosDetailActivity.this.finish();
                };
            }
        });

    }
}
