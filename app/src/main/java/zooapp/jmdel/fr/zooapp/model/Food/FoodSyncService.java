package zooapp.jmdel.fr.zooapp.model.Food;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by jean-michel on 13/06/2016.
 */
public class FoodSyncService extends IntentService {

/**
 * This service provides method to keep local list of Food and sync with webservice api...
 */

    public static final String CREATE_ACTION = "create";
    public static final String FOOD_NAME = "name";
    public static final String FOOD_TYPE = "type";
    public static final String FOOD_STOCK = "stock";
    public static final String FOOD_UNITY = "unity";
    public static final String FOOD_EATER = "eater";
    private static final String TAG = FoodSyncService.class.getSimpleName();
    public static final String PASSWORD = "jmdel1971";
    public static final String USERNAME = "jmdel";
    private static List<Food> previousResults = Collections.emptyList();

    /*Provides a name for the started thread, may be usefull in debug*/
    public FoodSyncService() {
        super(FoodSyncService.class.getSimpleName());
    }

    private static TextView view;

    /**
     * Starts this service to perform create food action with the given name. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startCreateFoodSyncAction(Context context,
                                                 String FoodName,
                                                 String type,
                                                 String stock,
                                                 String unity,
                                                 String eater,
                                                 TextView textView) {
        Intent intent = new Intent(context, FoodSyncService.class);
        intent.setAction(CREATE_ACTION);
        intent.putExtra(FOOD_NAME, FoodName);
        intent.putExtra(FOOD_TYPE, type);
        intent.putExtra(FOOD_STOCK, stock);
        intent.putExtra(FOOD_UNITY, unity);
        intent.putExtra(FOOD_EATER, eater);
        view = textView;
        context.startService(intent);
    }

    public static List<Food> startSyncLocalFoodAction() {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        FoodWSClient client = ServiceGenerator.createService(FoodWSClient.class);

        // Fetch and print a list of the foods of this owner.
        Call<List<Food>> call =
                client.foods();

        call.enqueue(new Callback<List<Food>>() {
                         @Override
                         public void onResponse(Call<List<Food>> call, retrofit2.Response<List<Food>> response) {
                             if (response.isSuccessful()) {
                                 StringBuilder builder = new StringBuilder("List of foods online : \n");
                                 List<Food> foods = response.body();
                                 for (Food food :
                                         foods) {
                                     builder.append(food.getName()).append('\n');
                                 }
                                 //textView.setText(builder.toString());
                                 previousResults = foods;
                             } else {
                                 String msg = "error response code from server: " + response.code();
                                 Log.e(TAG, msg);
                                 //textView.setText(msg);
                                 previousResults = Collections.emptyList();
                             }
                         }

                         @Override
                         public void onFailure(Call<List<Food>> call, Throwable t) {
                             String msg = t.getMessage();
                             Log.e(TAG, "failure : " +msg, t);
                             //textView.setText(msg);
                             previousResults = Collections.emptyList();
                         }
                     }
        );
        return previousResults;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (CREATE_ACTION.equals(action)) {
                final String foodName = intent.getStringExtra(FOOD_NAME);
                final String type = intent.getStringExtra(FOOD_TYPE);
                final Double stock = Double.valueOf(intent.getStringExtra(FOOD_STOCK));
                final String unity = intent.getStringExtra(FOOD_UNITY);
                final String eater = intent.getStringExtra(FOOD_EATER);
                Food food = new Food(foodName,type,stock,unity,eater);
                final TextView textView = view;
                handleCreateFood(food,textView);
            } else {
                Log.e(TAG, "Error: unrecognized Action : " + action);
            }
        }
    }

    /**
     * Handle action Food in the provided background thread with the provided
     * parameters.
     */
    private void handleCreateFood(Food food, final TextView textview) {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        FoodWSClient client = ServiceGenerator.createService(FoodWSClient.class, USERNAME, PASSWORD);
        //Food food = new Food(foodName,type,stock,unity,eater_type);
        //food.setName(foodName);
        final Call<Food> call = client.createFood(food);
        try {
            final Response<Food> execute = call.execute();
            textview.post(new Runnable() {
                @Override
                public void run() {
                    textview.setText(Integer.toString(execute.code()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            textview.post(new Runnable() {
                @Override
                public void run() {
                    textview.setText("Error!");
                }
            });
        }
    }


    public interface FoodWSClient {
        @GET("/foods")
        Call<List<Food>> foods();

        @GET("/food/{id}")
        Call<Food> food(@Path("id") int id);

        @POST("/food/add")
        Call<Food> createFood(@Body Food food);

        @PUT("/food/update")
        Call<Food> updateFood(@Body Food food);
    }

    public static class ServiceGenerator {

        public static final String API_BASE_URL = "http://10.0.2.2:8080";

        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        public static <S> S createService(Class<S> serviceClass) {
            Retrofit retrofit = builder.client(httpClient.build()).build();
            return retrofit.create(serviceClass);
        }

        public static <S> S createService(Class<S> serviceClass, String username, String password) {
            if (username != null && password != null) {
                String credentials = username + ":" + password;
                final String basic =
                        "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

                httpClient.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", basic)
                                .header("Accept", "application/json")
                                .method(original.method(), original.body());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });
            }

            OkHttpClient client = httpClient.build();
            Retrofit retrofit = builder.client(client).build();
            return retrofit.create(serviceClass);
        }
    }

}
