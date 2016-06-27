package zooapp.jmdel.fr.zooapp.enclos;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;
import zooapp.jmdel.fr.zooapp.enclos.model.EnclosAdapter;

public class EnclosServiceBind extends Service {
    ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();

    public EnclosServiceBind() {
    }

    public class GetListeEnclos extends Binder {
//        final ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();

        public ArrayList<Enclos> getListe(final EnclosAdapter adapter)
        {
            EnclosClient client = ServiceGenerator.createService(EnclosClient.class);
            Call<ArrayList<Enclos>> call =
                    client.listeEnclos();

            call.enqueue(new Callback<ArrayList<Enclos>>() {
                             @Override
                             public void onResponse(Call<ArrayList<Enclos>> call, Response<ArrayList<Enclos>> response) {
                                 if (response.isSuccessful()) {
                                     listeEnclos.clear();
                                     listeEnclos = response.body();
                                     adapter.clear();
                                     adapter.addAll(listeEnclos);
                                     adapter.notifyDataSetChanged();
                                     String toto = "toto";
//                                     previousResults = repos;
                                 } else {
                                     String msg = "error response code from server: " + response.code();
                                     Log.e("toto", msg);
//                                     previousResults = Collections.emptyList();
                                 }
                             }

                             @Override
                             public void onFailure(Call<ArrayList<Enclos>> call, Throwable t) {
                                 String msg = t.getMessage();
                                 Log.e("toti", "failure : " +msg, t);
//                                 previousResults = Collections.emptyList();
                             }
                         }
            );

            return listeEnclos;
        }

    }

    public interface EnclosClient {
        @GET("zooteam3/rest/json/enclos/liste")
//        @GET("/{path}")
       Call<ArrayList<Enclos>> listeEnclos();
//        Call<ArrayList<Enclos>> listeEnclos(@Path(value = "path",encoded=true) String owner);
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
        return new GetListeEnclos();
 //       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("blabla", "youîy");
    }


}
