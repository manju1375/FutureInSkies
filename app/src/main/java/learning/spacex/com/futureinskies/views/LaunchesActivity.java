package learning.spacex.com.futureinskies.views;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import learning.spacex.com.futureinskies.R;
import learning.spacex.com.futureinskies.adapter.LaunchesAdapter;
import learning.spacex.com.futureinskies.models.Launches;

public class LaunchesActivity extends AppCompatActivity implements LaunchesAdapter.OnItemClickListener{

    private static final String URL_DATA = "https://api.spacexdata.com/v2/launches/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Launches> launches;
    private LaunchesActivity activity;
    private VolleyRequestProcess task;
    private ProgressBar progressBar;
    private TextView loadingtextView;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvError =findViewById(R.id.tverror);
        tvError.setVisibility(View.GONE);
        progressBar = findViewById(R.id.progressbar);
        loadingtextView=findViewById(R.id.tvloading);
        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //task=(VolleyRequestProcess) getLastCustomNonConfigurationInstance();

        if (task==null) {
            showDialog();
            launches = new ArrayList<>();
            task = new VolleyRequestProcess(this);
           task.processRequest();
        }
        else {
            task.attach(this);
            //updateProgress(task.getProgress());
            markAsDone();
        }

        //loadUrlData();
    }

    @Override
    public void onItemClick(int item) {


        Intent rocketdetails =new Intent(activity,RocketDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("flightNumber",Integer.valueOf(launches.get(item).getFlightNumber()).toString());
        bundle.putString("missionName",launches.get(item).getMissionName());
        bundle.putString("launchDate",""+launches.get(item).getLaunchDateUnix());
        bundle.putString("launchwikiLink",launches.get(item).getLinks().getWikipedia());
        bundle.putString("launchVideolink",launches.get(item).getLinks().getVideoLink());
        bundle.putString("rocketName",launches.get(item).getRocket().getRocketId());
        bundle.putString("customerName", "");
        try{
            bundle.putString("customerName",launches.get(item).getRocket().getSecondStage().getPayloads().get(0).getCustomers().get(0));
        }
        catch (Exception e){
            bundle.putString("customerName", "");
        }
        rocketdetails.putExtras(bundle);
        startActivity(rocketdetails);

    }

   /*void markAsNotDone(){
        Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
    }*/

   class MyResponseListener implements Response.Listener<String>{


       @Override
       public void onResponse(String response) {
           Gson gson = new GsonBuilder().create();
           //Type listType = new TypeToken<List<Launches>>(){}.getType();
           //posts = Arrays.asList(gson.fromJson(reader, Post[].class));
           hideDialog();
           launches = Arrays.asList(gson.fromJson(response, Launches[].class));
           adapter =new LaunchesAdapter(launches,getApplicationContext(),activity);
           recyclerView.setAdapter(adapter);


       }
   }


    class VolleyRequestProcess {


        public VolleyRequestProcess(LaunchesActivity lactivity) {
           attach(lactivity);
        }
        protected void processRequest() {
            showDialog();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    URL_DATA, new MyResponseListener(), new MyErrorListener());
            RequestQueue requestQueue = Volley.newRequestQueue(LaunchesActivity.this);
            requestQueue.add(stringRequest);

        }
        void detach() {
            activity=null;
        }
        void attach(LaunchesActivity lactivity) {
            activity=lactivity;
        }

    }

    public void showDialog(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
              progressBar.setVisibility(View.VISIBLE);
              loadingtextView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void hideDialog(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                loadingtextView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        task.detach();
        return(task);
    }

   class MyErrorListener implements Response.ErrorListener{

       @Override
       public void onErrorResponse(VolleyError error) {
           hideDialog();
           tvError.setVisibility(View.VISIBLE);
           if (error instanceof TimeoutError ) {
                tvError.setText(getResources().getString(R.string.time_out_error));
           } else if (error instanceof NoConnectionError) {
               tvError.setText(getResources().getString(R.string.no_connection_error));
           } else if (error instanceof ServerError) {
               tvError.setText(getResources().getString(R.string.server_error));
           } else if (error instanceof NetworkError) {
               tvError.setText(getResources().getString(R.string.network_error));
           } else if (error instanceof ParseError) {
               tvError.setText(getResources().getString(R.string.parse_error));
           }
       }
   }

   public void markAsDone(){
           adapter = new LaunchesAdapter(launches,getApplicationContext(),activity);
           recyclerView.setAdapter(adapter);
   }

}