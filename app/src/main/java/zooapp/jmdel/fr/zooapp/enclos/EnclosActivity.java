package zooapp.jmdel.fr.zooapp.enclos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosAdapter;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;

public class EnclosActivity extends ListActivity {

    ArrayList<Enclos> enclos = new ArrayList<Enclos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos);

// ¨Partie enclos
        EnclosAdapter enclosAdapter = new EnclosAdapter(this, enclos);
        EnclosManager enclosManager = EnclosManager.getInstance(getApplicationContext());
        enclosManager.setEnclosAdapter(enclosAdapter);
        enclos = enclosManager.getListeEnclos();
        setListAdapter(enclosAdapter);

        FloatingActionButton newEnclos = (FloatingActionButton) findViewById(R.id.newEnclos);
        newEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnclosActivity.this,EnclosAddActivity.class);
                startActivity(intent);
            }
        });
    }

        @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//            Intent intent = new Intent(this,EnclosDetailActivity.class);
            Enclos enclos = (Enclos)l.getItemAtPosition(position);
//            Enclos enclot = EnclosManager.getInstance(getApplicationContext()).getEnclos(enclos.get(position));
            Intent intent = new Intent(this,EnclosDetailActivity.class);
            intent.putExtra("enclot",enclos);
            startActivity(intent);
    }


    protected void onRestart() {
        super.onRestart();
        EnclosAdapter enclosAdapter = new EnclosAdapter(this, enclos);
        EnclosManager enclosManager = EnclosManager.getInstance(getApplicationContext());
        enclosManager.setEnclosAdapter(enclosAdapter);
        enclos = enclosManager.getListeEnclos();
        setListAdapter(enclosAdapter);

//        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }

    }
