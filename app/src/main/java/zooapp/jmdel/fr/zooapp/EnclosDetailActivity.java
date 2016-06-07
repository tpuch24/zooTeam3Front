package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


    }
}
