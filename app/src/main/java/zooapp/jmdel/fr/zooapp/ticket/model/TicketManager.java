package zooapp.jmdel.fr.zooapp.ticket.model;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    protected ArrayList<Ticket> list = new ArrayList<>();
    protected static TicketManager instance;
    private int comp=0;

    TicketManager()
    {
        //super();
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
        list.add(new Ticket(0, 70, "Individuel", "06/06/2016", 10));
        list.add(new Ticket(1, 150, "Groupe", "06/06/2016", 2));
        list.add(new Ticket(2, 30, "Enfant", "06/06/2016", 15));
        comp=2;
    }
    public void add(Ticket tck)
    {
        comp++;
        tck.setId(comp);
        list.add(tck);

    }

    public void update(Ticket tck)
    {
        list.set(tck.getId(), tck);
    }

    public void delete(int id)
    {
        list.remove(id);
        comp--;
    }

    public ArrayList<Ticket> getList()
    {
        return list;
    }
    public ArrayList<Ticket> getList(List<Ticket> listRepos)
    {
        list = new ArrayList<>(listRepos);
        return list;
    }

    public Ticket getOneById(int pos)
    {
        return list.get(pos);
    }
}
