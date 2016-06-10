package zooapp.jmdel.fr.zooapp.ticket;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.ticket.model.Ticket;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketManager;

public class TicketsDetailsActivity extends AppCompatActivity {

    Ticket ticket = null;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_details);

     //   setData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_tickets_details);

        setData();
    }

    private void setData(){
        Intent intent = getIntent();

        //Put all object in a bundle
        Bundle extras = intent.getExtras();

        id=(int) extras.get("reference");
        Ticket ticket = TicketManager.getInstance().getOneById(id);

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

                Bundle extras = intent.getExtras();
                intent.putExtra("reference", id);
                startActivity(intent);
            }
        });

    }
}
