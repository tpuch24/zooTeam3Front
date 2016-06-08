package zooapp.jmdel.fr.zooapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import zooapp.jmdel.fr.zooapp.model.Ticket;

public class ViewTickets extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tickets);

        List<Ticket> list = new ArrayList<>();
        list.add(new Ticket("visiteur","1","06/06/2016",true, 120));
        list.add(new Ticket("visiteur","2","06/06/2016",false, 12));
        list.add(new Ticket("visiteur","3","06/06/2016",false, 10));

        ArrayAdapter<Ticket> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text, list);

        setListAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addticket);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ViewTickets.this,AddTicket.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(ViewTickets.this, TicketDetails.class);
        intent.putExtra("reference", l.getItemAtPosition(position).toString());
        startActivity(intent);
    }
}
