package zooapp.jmdel.fr.zooapp.enclos;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zooapp.jmdel.fr.zooapp.enclos.model.Enclos;

/**
 * Created by hb on 22/06/2016.
 */
public class EnclosServiceDelete extends Service{
//    private Enclos enclos = new Enclos() ;
    private Enclos enclos = new Enclos() ;
    private String result = new String();

    public class DeleteEnclos extends Binder {
        public String delete( Enclos enclo) {
            enclos = enclo;
            EnclosDelete delete = ServiceGenerator.createService(EnclosDelete.class);
            Call<String> call = delete.deleteEnclos(enclos.getId());
            call.enqueue(new Callback<String>() {
                             @Override
                             public void onResponse(Call<String> call, Response<String> response) {
                                 if (response.isSuccessful()) {
                                     Log.e("delete", "ok");
                                     result = response.body();
//                                     enclos = response.body();
                                     Log.e("delete","toto");
                                 } else {
                                     String msg = "error response code from server: " + response.code();
//                                     Log.e("toto", msg);
                                 }
                             }

                             @Override
                             public void onFailure(Call<String> call, Throwable t) {
                                 String msg = t.getMessage();
                                 Log.e("failure", "failure : " + msg, t);
//                                 previousResults = Collections.emptyList();
                             }
                         }
            );
            return result;
        }
    }

    public interface EnclosDelete {
        @DELETE("zooteam3/rest/json/enclos/delete/{id}")
        Call<String> deleteEnclos(@Path("id") int id);
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
        return new DeleteEnclos();
        //       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("blabla", "youîy");
    }

}
