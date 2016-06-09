package zooapp.jmdel.fr.zooapp.model;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    protected ArrayList<Ticket> list = new ArrayList<>();
    protected static TicketManager instance;

    private TicketManager()
    {
        super();
        initListe();
    }

    public static TicketManager getInstance()
    {
        if (instance==null){
            instance = new TicketManager();
        }
        return instance;
    }

    void initListe()
    {
        list.add(new Ticket(70, "Individuel", "06/06/2016", 10));
        list.add(new Ticket(150, "Groupe", "06/06/2016", 2));
        list.add(new Ticket(30, "Enfant", "06/06/2016", 15));
    }
    public void add(Ticket tck)
    {
        list.add(tck);
    }

    public void update(int id, Ticket tck)
    {
        list.set(id, tck);
    }

    public void remove(int id)
    {
        list.remove(id);
    }

    public ArrayList<Ticket> getList()
    {
        return list;
    }

    public Ticket getOneById(int pos)
    {
        return list.get(pos);
    }
}
