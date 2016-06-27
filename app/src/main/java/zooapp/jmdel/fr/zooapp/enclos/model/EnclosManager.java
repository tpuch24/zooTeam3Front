package zooapp.jmdel.fr.zooapp.enclos.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.enclos.EnclosService;
import zooapp.jmdel.fr.zooapp.enclos.EnclosServiceBind;
import zooapp.jmdel.fr.zooapp.enclos.EnclosServiceDelete;
import zooapp.jmdel.fr.zooapp.enclos.EnclosServiceUpdate;

/**
 * Created by hb on 07/06/2016.
 */
public class EnclosManager {
    private ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();
    private ArrayList<String> listeTypeEnclos = new ArrayList<String>();
    private static EnclosManager instEnclos;
    private Context context;
    private EnclosAdapter enclosAdapter;
    private Enclos pEnclos;

    private EnclosManager(Context pContext) {
        super();
        context = pContext;
    //    initListe();
    }

    public static EnclosManager getInstance(Context context){

        if (instEnclos==null){
            instEnclos = new EnclosManager(context);
        }
        return instEnclos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public EnclosAdapter getEnclosAdapter() {
        return enclosAdapter;
    }

    public void setEnclosAdapter(EnclosAdapter enclosAdapter) {
        this.enclosAdapter = enclosAdapter;
    }

    private void initListeType(){
        listeTypeEnclos.clear();
        String type = new String("Cage");
        listeTypeEnclos.add(type);
        type = "Enclos";
        listeTypeEnclos.add(type);
        type = "Vivarium";
        listeTypeEnclos.add(type);
        type = "Volière";
        listeTypeEnclos.add(type);
    }

    public ArrayList<Enclos> getListeEnclos(){
        Intent intent = new Intent(context, EnclosServiceBind.class);
        boolean success = context.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                EnclosServiceBind.GetListeEnclos enclosServiceB = (EnclosServiceBind.GetListeEnclos) service;
                listeEnclos = enclosServiceB.getListe(enclosAdapter);
//                Log.e("blabla", new Integer(listeEnclos.size()).toString());
                // Appeler une callback du ListView pour le refraichir
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("blabla", "Disconnected");
            }
        },Context.BIND_AUTO_CREATE);
//       Log.e("blabla", "binding");
         return listeEnclos;
    }


    public ArrayList<String> getListeTypeEnclos(){
        initListeType();
        return listeTypeEnclos;
    }

    public Enclos updateEnclos(final Enclos enclos, Context cont) {
        Intent intent = new Intent(cont, EnclosServiceUpdate.class);
        boolean success = cont.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                EnclosServiceUpdate.UpdateEnclos enclosServiceB = (EnclosServiceUpdate.UpdateEnclos) service;
                pEnclos = enclosServiceB.updateX(enclos);
                Log.e("blabla", "Appel du bind");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("blabla", "Disconnected");
            }
        },Context.BIND_AUTO_CREATE);
       Log.e("blabla", "Appel binding");
        return pEnclos;
    }

    public Enclos selectEnclos(final Enclos enclos, final TextView textNom,
                               final TextView textNbAnimal,
                               final TextView textType) {

        Intent intent = new Intent(context, EnclosService.class);
        boolean success = context.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                EnclosService.SelectEnclos enclosServiceB = (EnclosService.SelectEnclos) service;
                pEnclos = enclosServiceB.select(enclos,textNom,textNbAnimal,textType);
                Log.e("update", "Connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("blabla", "Disconnected");
            }
        },Context.BIND_AUTO_CREATE);
//       Log.e("blabla", "binding");
        return pEnclos;
    }

    public Enclos getEnclos(Enclos enclos) {
        return enclos;
    }

    public ArrayList<Enclos> getListe()
    {
        listeEnclos.clear();
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
    public boolean addEnclos(Enclos enclos) {
        Intent intent = new Intent(context, EnclosService.class);
        intent.setAction("INSERT");
        intent.putExtra("Enclos",enclos);
        context.startService(intent);
        return true;
    }

    public boolean deleteEnclos(final Enclos enclos) {
        Log.e("delete", new Integer(enclos.getId()).toString());
        Intent intent = new Intent(context, EnclosServiceDelete.class);
        boolean success = context.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                EnclosServiceDelete.DeleteEnclos enclosServiceB = (EnclosServiceDelete.DeleteEnclos) service;
                enclosServiceB.delete(enclos);
                Log.e("delete", "Connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("delete", "Disconnected");
            }
        },Context.BIND_AUTO_CREATE);
        Log.e("delete", "Pas de bind");

//       Log.e("blabla", "binding");
        return true;
    }

}
