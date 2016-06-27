package zooapp.jmdel.fr.zooapp.enclos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;

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

        TextView textNom = (TextView) findViewById(R.id.nom);
        TextView textNbAnimaux = (TextView) findViewById(R.id.nbAnimaux);
        TextView textType = (TextView) findViewById(R.id.type);
        EnclosManager enclosM = EnclosManager.getInstance(getApplicationContext());
        Enclos encloss = enclosM.selectEnclos(enclo,textNom, textNbAnimaux, textType);

        EnclosManager enclosMM = EnclosManager.getInstance(getApplicationContext());
        boolean bol = enclosMM.deleteEnclos(enclo);

        FloatingActionButton updateEnclos = (FloatingActionButton) findViewById(R.id.updateEnclos);
        updateEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnclosDetailActivity.this,EnclosUpdateActivity.class);
                intent.putExtra("Enclos",enclo);
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
                EnclosManager enclosM = EnclosManager.getInstance(getApplicationContext());
                enclosM.setContext(getApplicationContext());
                enclosM.deleteEnclos(enclo);
                EnclosDetailActivity.this.finish();
                };
        });

    }
}
