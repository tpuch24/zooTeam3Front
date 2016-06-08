package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.model.Ticket;

public class TicketsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_details);

        Intent intent = getIntent();

        //Put all object in a bundle
        Bundle extras = intent.getExtras();

        final Ticket ticket = (Ticket) extras.get("reference");

        TextView txtv = (TextView)findViewById(R.id.textView2);
        assert txtv != null;
        txtv.setText(ticket.getDate());

        txtv = (TextView)findViewById(R.id.textView3);
        assert txtv != null;
        txtv.setText(ticket.getCategory());

        txtv = (TextView)findViewById(R.id.textView4);
        assert txtv != null;
        txtv.setText( String.valueOf(ticket.getNumber_sold()));

        txtv = (TextView)findViewById(R.id.textView5);
        assert txtv != null;
        txtv.setText(String.valueOf(ticket.getIncome()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.ticketUpdate);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TicketsDetailsActivity.this,TicketsUpdateActivity.class);
                intent.putExtra("reference", ticket);
                startActivity(intent);
            }
        });

    }
}
