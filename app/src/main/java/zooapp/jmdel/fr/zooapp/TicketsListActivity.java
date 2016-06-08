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

public class TicketsListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_list);

        List<Ticket> list = new ArrayList<>();
        list.add(new Ticket(70, "Individuel", "06/06/2016", 10));
        list.add(new Ticket(150, "Groupe", "06/06/2016", 2));
        list.add(new Ticket(30, "Enfant", "07/06/1702", 15));

        ArrayAdapter<Ticket> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text, list);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(TicketsListActivity.this, TicketsDetailsActivity.class);
        intent.putExtra("reference", l.getItemAtPosition(position).toString());
        startActivity(intent);
    }
}
