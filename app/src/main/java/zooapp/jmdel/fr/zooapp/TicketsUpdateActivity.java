package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Ticket;

public class TicketsUpdateActivity extends AppCompatActivity {

    Ticket ticket = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        //Put all object in a bundle
        Bundle extras = intent.getExtras();

        ticket = (Ticket) extras.get("reference");

        TextView txtv = (TextView)findViewById(R.id.textView2);
        assert txtv != null;
        txtv.setText(ticket.getDate());

        txtv = (TextView)findViewById(R.id.textView3);
        assert txtv != null;
        txtv.setText(ticket.getCategory());

        txtv = (EditText)findViewById(R.id.editText);
        assert txtv != null;
        txtv.setText( String.valueOf(ticket.getNumber_sold()));

        txtv = (EditText)findViewById(R.id.editText2);
        assert txtv != null;
        txtv.setText(String.valueOf(ticket.getIncome()));


        FloatingActionButton fap = (FloatingActionButton) findViewById(R.id.ticketUpdate);
        assert fap != null;
        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Updated! No I'm kiding, go to work...", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();

                EditText txtv = (EditText)findViewById(R.id.editText);
                assert txtv != null;
                ticket.setNumber_sold(Integer.getInteger(txtv.getText().toString()));

                txtv = (EditText)findViewById(R.id.editText2);
                assert txtv != null;
                ticket.setIncome(Integer.getInteger(txtv.getText().toString()));

            }
        });

    }

}
