package zooapp.jmdel.fr.zooapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.model.Enclos;
import zooapp.jmdel.fr.zooapp.model.EnclosAdapter;
import zooapp.jmdel.fr.zooapp.model.EnclosManager;

public class EnclosActivity extends ListActivity {

    ArrayList<Enclos> enclos = EnclosManager.getInstance().getListeAnimal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos);

        EnclosAdapter enclosAdapter = new EnclosAdapter(this, enclos);
        setListAdapter(enclosAdapter);

        FloatingActionButton suppEnclos = (FloatingActionButton) findViewById(R.id.suppEnclos);
        suppEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Suppression d'enclos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

        @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
            Intent intent = new Intent(this,EnclosDetailActivity.class);
            intent.putExtra("enclot",enclos.get(position));
            startActivity(intent);
    }

}
