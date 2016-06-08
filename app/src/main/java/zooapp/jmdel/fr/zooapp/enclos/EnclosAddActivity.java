package zooapp.jmdel.fr.zooapp.enclos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.R;

public class EnclosAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclos_add);

        FloatingActionButton cancelEnclos = (FloatingActionButton) findViewById(R.id.cancelEnclos);
        cancelEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText)findViewById(R.id.nom)).setText("");
                ((EditText)findViewById(R.id.nbAnimaux)).setText("");
            }
        });

        FloatingActionButton saveEnclos = (FloatingActionButton) findViewById(R.id.saveEnclos);
        saveEnclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ajout d'enclos à coder", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
