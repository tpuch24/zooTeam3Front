package zooapp.jmdel.fr.zooapp.enclos;

import android.app.IntentService;
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
 * Created by hb on 22/06/2016.
 */
public class EnclosServiceUpdate extends Service {

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

    public EnclosServiceUpdate() {
    }

    public class UpdateEnclos extends Binder {
        public Enclos updateX( Enclos enclo) {
            enclos = enclo;
//            urlRest = urlRest + enclos.getId();
            EnclosUpdate up = ServiceGenerator.createService(EnclosUpdate.class);
            Call<Enclos> call = up.updateEnclos(enclos.getId());
            call.enqueue(new Callback<Enclos>() {
                             @Override
                             public void onResponse(Call<Enclos> call, Response<Enclos> response) {
                                 if (response.isSuccessful()) {
                                     Log.e("response", "ok");
                                     enclos = response.body();
                                     Log.e("response",enclos.getNom());
                                 } else {
                                     String msg = "error response code from server: " + response.code();
                                     Log.e("toto", msg);
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

    public interface EnclosUpdate {
        @GET("zooteam3/rest/json/enclos/{id}")
        Call<Enclos> updateEnclos(@Path("id") int id);

//        @POST("zooteam3/rest/json/enclos/update")
//        Call<Enclos> updateEnclos(@Body Enclos enclos);
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
        return new UpdateEnclos();
        //       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("blabla", "youîy");
    }


}
