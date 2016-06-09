package zooapp.jmdel.fr.zooapp.model;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    protected ArrayList<Ticket> list = new ArrayList<>();
    protected static TicketManager instance;

    private TicketManager(){
        super();
        initListe();
    }

    public static TicketManager getInstance(){

        if (instance==null){
            instance = new TicketManager();
        }
        return instance;
    }

    public Ticket getOne(int id){
        for (Ticket t: list)
        {
            //find the ticket to remove
            if(t.id==id)
            {
                return t;
            }
        }
        return null;
    }

    protected void initListe() {
        list.add(new Ticket(1, 70, "Individuel", "06/06/2016", 10));
        list.add(new Ticket(2, 150, "Groupe", "06/06/2016", 2));
        list.add(new Ticket(3, 30, "Enfant", "06/06/2016", 15));
    }
    public void update(Ticket tck)
    {
        Ticket t = getOne(tck.id);
                list.remove(t);
                list.add(tck);
        //list.indexOf()
    }
    public ArrayList<Ticket> getList(){return list;}
}
