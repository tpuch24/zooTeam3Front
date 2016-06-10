package zooapp.jmdel.fr.zooapp.enclos;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class EnclosService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String DELETE = "DELETE";
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";

    // TODO: Rename parameters
//    public static final String EXTRA_PARAM1 = "zooapp.jmdel.fr.zooapp.enclos.extra.PARAM1";
//    public static final String EXTRA_PARAM2 = "zooapp.jmdel.fr.zooapp.enclos.extra.PARAM2";

    public EnclosService() {
        super("EnclosService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (INSERT.equals(action)) {
                Enclos enclos = (Enclos) (intent.getExtras().get("Enclos"));
                insert(enclos);
            } else if (UPDATE.equals(action)) {
                Enclos enclos = (Enclos) (intent.getExtras().get("Enclos"));
                update(enclos);
            } else if (DELETE.equals(action)) {
                Enclos enclos = (Enclos) (intent.getExtras().get("Enclos"));
                delete(enclos);
            }
        }
    }

    private void update(Enclos enclos) {
        Toast toast = Toast.makeText(getApplicationContext(), "Mise à jour bien effectuée", Toast.LENGTH_LONG);
        toast.show();
    }

    private void insert(Enclos enclos) {
        Toast toast = Toast.makeText(getApplicationContext(), "Création bien effectuée", Toast.LENGTH_LONG);
        toast.show();
    }
    private void delete(Enclos enclos) {
        Toast toast = Toast.makeText(getApplicationContext(), "Suppresion bien effectuée", Toast.LENGTH_LONG);
        toast.show();
    }
}
