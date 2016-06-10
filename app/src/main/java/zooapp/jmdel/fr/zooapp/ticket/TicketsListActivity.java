package zooapp.jmdel.fr.zooapp.ticket;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.ticket.model.Ticket;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketAdapter;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketManager;

public class TicketsListActivity extends ListActivity {

    ArrayList<Ticket> ticketslist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_list);

        setDatas();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_tickets_list);

        setDatas();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(TicketsListActivity.this, TicketsDetailsActivity.class);
        intent.putExtra("reference", position);
        startActivity(intent);
    }
    private void setDatas()
    {
        ticketslist = TicketManager.getInstance().getList();

        ArrayAdapter<Ticket> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text, ticketslist);

        TicketAdapter ticketAdapter = new TicketAdapter(this, ticketslist);

        setListAdapter(ticketAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addticket);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TicketsListActivity.this,TicketsAddActivity.class);
                startActivity(intent);
            }
        });

    }
}
