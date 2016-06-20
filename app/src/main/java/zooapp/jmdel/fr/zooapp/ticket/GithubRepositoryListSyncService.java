package zooapp.jmdel.fr.zooapp.ticket;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

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
import zooapp.jmdel.fr.zooapp.ticket.model.Ticket;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketAdapter;
import zooapp.jmdel.fr.zooapp.ticket.model.TicketManager;

/**
 * This service provides method to keep local list of repositories in sync with the one on Github...
 */
public class GithubRepositoryListSyncService extends IntentService {

    public static final String CREATE_ACTION = "create";
    public static final String REPOSITORY_NAME = "category";
    private static final String TAG = GithubRepositoryListSyncService.class.getSimpleName();
    private static List<Ticket> previousResults = Collections.emptyList();

    /*Provides a name for the started thread, may be usefull in debug*/
    public GithubRepositoryListSyncService() {
        super(GithubRepositoryListSyncService.class.getSimpleName());
    }

    /**
     * Starts this service to perform create repository action with the given name. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startCreateRepositoryAction(Context context, String repositoryName) {
        Intent intent = new Intent(context, GithubRepositoryListSyncService.class);
        intent.setAction(CREATE_ACTION);
        intent.putExtra(REPOSITORY_NAME, repositoryName);
        context.startService(intent);
    }

    public static List<Ticket> startSyncLocalRepositoryAction(String username) {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);

        // Fetch and print a list of the repos of this owner.
        Call<List<Ticket>> call =
                client.repositories(username);

        call.enqueue(new Callback<List<Ticket>>() {
                         @Override
                         public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                             if (response.isSuccessful()) {
                                 //StringBuilder builder = new StringBuilder("List of repos online : \n");
                                 List<Ticket> repos = response.body();

/*                                 for (Ticket repo :
                                         repos) {
                                     //builder.append(repo.getCategory()).append('\n');
                                 }*/
                                 //textView.setText(builder.toString());
                                 previousResults = repos;
                             } else {
                                 String msg = "error response code from server: " + response.code();
                                 Log.e(TAG, msg);
                                 //textView.setText(msg);
                                 previousResults = Collections.emptyList();
                             }
                         }

                         @Override
                         public void onFailure(Call<List<Ticket>> call, Throwable t) {
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
                final String param1 = intent.getStringExtra(REPOSITORY_NAME);
                handleCreateRepository(param1);
            } else {
                Log.e(TAG, "Error: unrecognized Action : " + action);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleCreateRepository(String repositoryName) {
        // TODO: Handle create repository action
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public interface GitHubClient {
        @GET("/{path}")
        Call<List<Ticket>> repositories(
                @Path(value = "path", encoded = true) String owner
        );
    }

    public static class ServiceGenerator {

        public static final String API_BASE_URL = "http://10.0.2.2:8080/";

        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        public static <S> S createService(Class<S> serviceClass) {
            Retrofit retrofit = builder.client(httpClient.build()).build();
            return retrofit.create(serviceClass);
        }
    }

}
