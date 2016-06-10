package zooapp.jmdel.fr.zooapp.enclos;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;

public class EnclosServiceBind extends Service {
    public EnclosServiceBind() {
    }

    public class GetListeEnclos extends Binder {
        public ArrayList<Enclos> getListe()
        {
            ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();
            Enclos enclos = new Enclos( "Enclos des lions", 3, 7, "Cage");
            enclos.setId(1);
            listeEnclos.add(enclos);
            enclos = new Enclos("Enclos des oiseaux", 8, 12, "Volière");
            enclos.setId(5);
            listeEnclos.add(enclos);
            enclos = new Enclos("Parc des reptiles", 40, 60, "Vivarium");
            enclos.setId(6);
            listeEnclos.add(enclos);
            enclos = new Enclos("Enclos nord", 0, 10, "Enclos");
            listeEnclos.add(enclos);
            enclos.setId(9);

            return listeEnclos;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        Log.e("blabla", "bind");
        return new GetListeEnclos();
 //       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.e("blabla", "youîy");
    }
}
