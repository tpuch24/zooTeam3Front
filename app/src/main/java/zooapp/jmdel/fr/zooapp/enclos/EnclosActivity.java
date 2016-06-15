package zooapp.jmdel.fr.zooapp.enclos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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
//        enclos = EnclosManager.getInstance(getApplicationContext()).getListeEnclos();
//        enclosAdapter.addAll(enclos);

        setListAdapter(enclosAdapter);
//        Enclos encl = new Enclos("toto",2,4,"titi");
//        encl.setId(78);
//        enclosAdapter.add(encl);
//        enclosAdapter.notifyDataSetChanged();

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
            Intent intent = new Intent(this,EnclosDetailActivity.class);
            Enclos enclot = EnclosManager.getInstance(getApplicationContext()).getEnclos(enclos.get(position));
            intent.putExtra("enclot",enclot);
            startActivity(intent);
    }


    protected void onRestart() {
        super.onRestart();
        enclos.clear();
        enclos = EnclosManager.getInstance(getApplicationContext()).getListeEnclos();
        EnclosAdapter enclosAdapter = new EnclosAdapter(this, enclos);
        setListAdapter(enclosAdapter);
//        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }

    }
