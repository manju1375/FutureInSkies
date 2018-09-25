package learning.spacex.com.futureinskies.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.Arrays;

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
        task=(VolleyRequestProcess) getLastCustomNonConfigurationInstance();

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
        //customerString = intent.getString("customerString");

        launchFlighttv.setText(flightNumber);
        launchMissiontv.setText(missionName);
        launchDatetv.setText(launchDate);
        launchWikitv.setText(launchwikiLink);
        launchVideotv.setText(launchVideolink);
        //launchcustomertv.setText(customerString);

        URL_DATA.append(intent.getString("rocketName"));

    }

    public void initalizeViews(){
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
        rocketNameTv.setText(rocketDetails.getName());
        rocketDescTv.setText(rocketDetails.getDescription());
        rocketWikiTv.setText(rocketDetails.getWikipedia());
        rocketEngineTypeTv.setText(rocketDetails.getEngines().getType());
        rocketEngineVersionTv.setText(rocketDetails.getEngines().getVersion());
        //rocketLandingLegsTv.setText(""+rocketDetails.getLandingLegs().getNumber());
        //rocketLandingMaterialTv.setText(""+rocketDetails.getLandingLegs().getMaterial());
    }
}
