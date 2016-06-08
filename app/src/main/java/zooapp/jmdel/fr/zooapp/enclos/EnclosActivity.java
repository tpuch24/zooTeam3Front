package zooapp.jmdel.fr.zooapp.enclos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosAdapter;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosManager;

public class EnclosActivity extends ListActivity {

    ArrayList<Enclos> enclos = EnclosManager.getInstance().getListeEnclos();

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

//    protected void onResume (Bundle savedInstanceState) {
//
//    }

        @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
            Intent intent = new Intent(this,EnclosDetailActivity.class);
            intent.putExtra("enclot",enclos.get(position));
            startActivity(intent);
    }

}
