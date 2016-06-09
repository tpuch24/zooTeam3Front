package zooapp.jmdel.fr.zooapp.enclos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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
            intent.putExtra("enclot",enclos.get(position));
            startActivity(intent);
    }

    protected void onRestart() {
        super.onRestart();
        enclos = EnclosManager.getInstance().getListeEnclos();
        EnclosAdapter enclosAdapter = new EnclosAdapter(this, enclos);
        setListAdapter(enclosAdapter);
//        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }

    }
