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
import zooapp.jmdel.fr.zooapp.ticket.service.NetworkTicketService;

public class TicketsAddActivity extends AppCompatActivity
{
    Ticket ticket = null;
    int id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_add);
        setDatas();
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        setContentView(R.layout.activity_tickets_add);
        setDatas();
    }

    private void setDatas()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ticket = new Ticket();

        TextView txtv = (TextView)findViewById(R.id.editText);
        assert txtv != null;
        txtv.setText("01/01/01");

        //start service
        Intent intent = new Intent(this, NetworkTicketService.class);
        intent.setAction("ACTION_GET_LIST");
        this.startService(intent);
        this.;

       // bindService();

        FloatingActionButton fap = (FloatingActionButton) findViewById(R.id.ticketAdd);
        assert fap != null;
        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtv = (EditText)findViewById(R.id.editText);
                String str = txtv.getText().toString();
               // int i=Integer.valueOf(str);
                if(txtv.getText().toString().length()!=0)
                {
                ticket.setDate(str);
                }
                else
                {
                    error(view, "1er champ vide ! Veuillez saisir une date");
                    return;
                }

                txtv = (EditText)findViewById(R.id.editText2);
                if(txtv.getText().toString().length()!=0)
                {
                ticket.setCategory(txtv.getText().toString());
                }
                else
                {
                    error(view, "2e champ vide ! Veuillez saisir une catégorie");
                    return;
                }

                txtv = (EditText)findViewById(R.id.editText3);
                if(txtv.getText().toString().length()!=0)
                {
                    ticket.setNumber_sold(Integer.valueOf(txtv.getText().toString()));
                }
                else
                {
                    error(view, "3e champ vide ! Veuillez saisir un nombre de ticket vendu");
                    return;
                }

                txtv = (EditText)findViewById(R.id.editText4);
                if(txtv.getText().toString().length()!=0) {
                    ticket.setIncome(Integer.valueOf(txtv.getText().toString()));
                }
                else
                {
                    error(view, "4e champ vide ! Veuillez saisir la recete");
                    return;
                }

                TicketManager.getInstance().add(ticket);

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
