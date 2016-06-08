package zooapp.jmdel.fr.zooapp.model;

import java.util.ArrayList;

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

    protected void initListe() {
        list.add(new Ticket("visiteur", "1", "06/06/2016", true, 120));
        list.add(new Ticket("visiteur", "2", "06/06/2016", false, 12));
        list.add(new Ticket("visiteur", "3", "06/06/2016", false, 10));
    }
}
