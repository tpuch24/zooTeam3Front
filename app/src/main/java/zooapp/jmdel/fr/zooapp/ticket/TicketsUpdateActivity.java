package zooapp.jmdel.fr.zooapp.ticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.R;
import zooapp.jmdel.fr.zooapp.ticket.model.Ticket;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketManager;

public class TicketsUpdateActivity extends AppCompatActivity {

    Ticket ticket = null;
    int id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_update);
        setDatas();
    }
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_tickets_update);
        setDatas();
    }

    private void setDatas()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        //Put all object in a bundle
        Bundle extras = intent.getExtras();


        id=(int) extras.get("reference");
        ticket = TicketManager.getInstance().getOneById(id);

        TextView txtv = (TextView)findViewById(R.id.textView2);
        assert txtv != null;
        txtv.setText(ticket.getDate());

        txtv = (TextView)findViewById(R.id.textView3);
        assert txtv != null;
        txtv.setText(ticket.getCategory());

        txtv = (EditText)findViewById(R.id.editText);
        assert txtv != null;
        txtv.setText( String.valueOf(ticket.getNumberSold()));

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

                if(txtv.getText().toString().length()!=0)
                {
                    int i=Integer.valueOf(txtv.getText().toString());
                    ticket.setNumberSold(i);
                }
                else
                {
                    error(view, "3e champ vide ! Veuillez saisir un nombre de ticket vendu");
                    return;
                }

                txtv = (EditText)findViewById(R.id.editText2);
                if(txtv.getText().toString().length()!=0)
                {
                    ticket.setIncome(Integer.valueOf(txtv.getText().toString()));
                }
                else
                {
                    error(view, "4e champ vide ! Veuillez saisir la recette");
                    return;
                }

                TicketManager.getInstance().update(ticket);

                finish();
            }
        });
    }
    void error(View view, String str)
    {
        Snackbar.make(view, str, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
