package zooapp.jmdel.fr.zooapp.enclos;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.JsonWriter;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class EnclosService extends Service {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String DELETE = "DELETE";
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String SELECT = "SELECT";
    private Enclos enclos = new Enclos() ;
    private static String urlRest = "zooteam3/rest/json/";

    // TODO: Rename parameters
//    public static final String EXTRA_PARAM1 = "zooapp.jmdel.fr.zooapp.enclos.extra.PARAM1";
//    public static final String EXTRA_PARAM2 = "zooapp.jmdel.fr.zooapp.enclos.extra.PARAM2";

    public EnclosService() {
    }

    public class SelectEnclos extends Binder {
        public Enclos select( Enclos enclo,
                              final TextView textNom,
                              final TextView textNbAnimal,
                              final TextView textType) {
            enclos = enclo;
            EnclosSelect select = ServiceGenerator.createService(EnclosSelect.class);
            Call<Enclos> call = select.selectEnclos(enclos.getId());
            call.enqueue(new Callback<Enclos>() {
                             @Override
                             public void onResponse(Call<Enclos> call, Response<Enclos> response) {
                                 if (response.isSuccessful()) {
                                     Log.e("response", "ok");
                                     enclos = response.body();
                                     textNom.setText(enclos.getNom());
                                     textNbAnimal.setText(enclos.getNbAnimalString());
                                     textType.setText(enclos.getType());
                                     Log.e("response",enclos.getNom());
                                 } else {
                                     String msg = "error response code from server: " + response.code();
//                                     Log.e("toto", msg);
                                 }
                             }

                             @Override
                             public void onFailure(Call<Enclos> call, Throwable t) {
                                 String msg = t.getMessage();
                                 Log.e("failure", "failure : " + msg, t);
//                                 previousResults = Collections.emptyList();
                             }
                         }
            );
            return enclos;
        }
    }

    public interface EnclosSelect {
        @GET("zooteam3/rest/json/enclos/{id}")
        Call<Enclos> selectEnclos(@Path("id") int id);
    }

    public static class ServiceGenerator {

        public static final String API_BASE_URL = "http://10.0.2.2:8080/";

        private  static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        public static <S> S createService(Class<S> serviceClass) {
            Retrofit retrofit = builder.client(httpClient.build()).build();
            return retrofit.create(serviceClass);
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("blabla", "bind");
        return new SelectEnclos();
        //       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("blabla", "youîy");
    }

}
