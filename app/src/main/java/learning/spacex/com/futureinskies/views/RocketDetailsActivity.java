package learning.spacex.com.futureinskies.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import org.w3c.dom.Text;

import java.util.Arrays;

import learning.spacex.com.futureinskies.DateUtils;
import learning.spacex.com.futureinskies.R;
import learning.spacex.com.futureinskies.adapter.LaunchesAdapter;
import learning.spacex.com.futureinskies.models.Launches;
import learning.spacex.com.futureinskies.models.RocketDetails;

public class RocketDetailsActivity extends AppCompatActivity {


    private  StringBuilder URL_DATA = new StringBuilder().append("https://api.spacexdata.com/v2/rockets/");
    // launch details
    private String flightNumber;
    private String missionName;
    private String launchDate;
    private String launchwikiLink;
    private String launchVideolink;
    private String customerString;

    private TextView launchFlighttv;
    private TextView launchMissiontv;
    private TextView launchDatetv;
    private TextView launchWikitv;
    private TextView launchVideotv;
    private TextView launchcustomertv;

    // rocket details
    private String rocketName;
    private String rocketDesc;
    private String rocketWiki;
    private String rocketEngineType;
    private String rocketEngineVersion;
    private String rocketLandingLegs;
    private String rocketLandingMaterial;

    private TextView rocketNameTv;
    private TextView rocketDescTv;
    private TextView rocketWikiTv;
    private TextView rocketEngineTypeTv;
    private TextView rocketEngineVersionTv;
    private TextView rocketLandingLegsTv;
    private TextView rocketLandingMaterialTv;
    private TextView tvError;

    private ProgressBar progressBar;
    private TextView loadingtextView;

    private VolleyRequestProcess task;
    private RocketDetails rocketDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rocket_details_main);
        initalizeViews();
        getAndSetLaunchDetails();
        //task=(VolleyRequestProcess) getLastCustomNonConfigurationInstance();

        if (task==null) {
            showDialog();
            task = new VolleyRequestProcess(this);
            task.processRequest();
        }
        else {
            task.attach(this);
            //updateProgress(task.getProgress());
            setRocketDetails();
        }

    }

    class VolleyRequestProcess {
        RocketDetailsActivity activity;

        public VolleyRequestProcess(RocketDetailsActivity activity) {
            attach(activity);
        }
        protected void processRequest() {
            showDialog();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    URL_DATA.toString(), new RocketDetailsActivity.MyResponseListener(), new RocketDetailsActivity.MyErrorListener());
            RequestQueue requestQueue = Volley.newRequestQueue(RocketDetailsActivity.this);
            requestQueue.add(stringRequest);
        }
        void detach() {
            activity=null;
        }
        void attach(RocketDetailsActivity activity) {
            this.activity=activity;
        }

    }

    class MyResponseListener implements Response.Listener<String>{


        @Override
        public void onResponse(String response) {
            Gson gson = new GsonBuilder().create();
            hideDialog();
            rocketDetails=gson.fromJson(response, RocketDetails.class);
            setRocketDetails();
        }
    }

    class MyErrorListener implements Response.ErrorListener{

        @Override
        public void onErrorResponse(VolleyError error) {
            hideDialog();
            tvError.setVisibility(View.VISIBLE);
            if (error instanceof TimeoutError) {
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

    public void getAndSetLaunchDetails(){

        Bundle intent =getIntent().getExtras();
        flightNumber= intent.getString("flightNumber");
        missionName = intent.getString("missionName");
        launchDate = intent.getString("launchDate");
        launchwikiLink = intent.getString("launchwikiLink");
        launchVideolink = intent.getString("launchVideolink");
        customerString = intent.getString("customerName");

        launchFlighttv.setText("Flight No: "+flightNumber);
        launchMissiontv.setText("Mission Name: "+missionName);
        launchDatetv.setText("Launch Date:"+"\n"+ DateUtils.convertUnixdateToString(Long.parseLong(launchDate)));
        launchWikitv.setText("Wiki Link:"+"\n"+launchwikiLink);
        launchVideotv.setText("Video Link:"+"\n"+launchVideolink);
        if(!customerString.equalsIgnoreCase("")){
            launchcustomertv.setText("Customer Name: "+customerString);
        }


        URL_DATA.append(intent.getString("rocketName"));

    }

    public void initalizeViews(){
        tvError =findViewById(R.id.tverror);
        tvError.setVisibility(View.GONE);
        launchFlighttv =findViewById(R.id.tvflightnumber);
        launchMissiontv =findViewById(R.id.tvmissionname);
        launchDatetv =findViewById(R.id.tvlaunchdate);
        launchWikitv = findViewById(R.id.tvlaunchwiki);
        launchVideotv = findViewById(R.id.tvlaunchyouttube);
        launchcustomertv = findViewById(R.id.tvlaunchcustomer);

        rocketNameTv = findViewById(R.id.rocketname);
        rocketDescTv = findViewById(R.id.rocketdesc);
        rocketWikiTv = findViewById(R.id.rocketwiki);
        rocketEngineTypeTv = findViewById(R.id.enginetype);
        rocketEngineVersionTv = findViewById(R.id.engineversion);
        rocketLandingLegsTv = findViewById(R.id.landinglegsnumber);
        rocketLandingMaterialTv = findViewById(R.id.landinglegsmaterial);

        progressBar = findViewById(R.id.progressbar);
        loadingtextView=findViewById(R.id.tvloading);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        task.detach();
        return(task);
    }

    public void setRocketDetails(){
        rocketNameTv.setText("Name: "+rocketDetails.getName());
        rocketDescTv.setText("Desc:"+"\n"+rocketDetails.getDescription());
        rocketWikiTv.setText("Wiki Link:"+"\n"+rocketDetails.getWikipedia());
        rocketEngineTypeTv.setText("EngineType: "+rocketDetails.getEngines().getType());
        rocketEngineVersionTv.setText("Engine Version: "+rocketDetails.getEngines().getVersion());
        //rocketLandingLegsTv.setText("Landing Legs No: "+rocketDetails.getLandingLegs().getNumber());
        if(rocketDetails.getLandingLegs().getMaterial()!=null)
            rocketLandingLegsTv.setText("Landing Legs No and Material:"+"\n"+rocketDetails.getLandingLegs().getNumber()+" and "+rocketDetails.getLandingLegs().getMaterial().toString());
        else
            rocketLandingLegsTv.setText("Landing Legs No: "+rocketDetails.getLandingLegs().getNumber());
    }
}
