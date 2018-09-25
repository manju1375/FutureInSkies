package learning.spacex.com.futureinskies.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class RocketDetailsActivity extends Activity {


    private static final String URL_DATA = "https://api.spacexdata.com/v2/rockets/";
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rocket_details);
        initalizeViews();
        getAndSetLaunchDetails();

    }

    class VolleyRequestProcess {
        RocketDetailsActivity activity;

        public VolleyRequestProcess(RocketDetailsActivity activity) {
            attach(activity);
        }
        protected void processRequest() {
            //showDialog();
           /* StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    URL_DATA, new RocketDetailsActivity.MyResponseListener(), new RocketDetailsActivity.MyErrorListener());
            RequestQueue requestQueue = Volley.newRequestQueue(RocketDetailsActivity.this);
            requestQueue.add(stringRequest);*/

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
            //Type listType = new TypeToken<List<Launches>>(){}.getType();
            //posts = Arrays.asList(gson.fromJson(reader, Post[].class));
            //hideDialog();
        }
    }

    /*class MyErrorListener implements Response.ErrorListener{

        @Override
        public void onErrorResponse(VolleyError error) {
            hideDialog();
        }
    }*/

    public void getAndSetLaunchDetails(){

        Intent intent =getIntent();
        flightNumber= intent.getStringExtra("flightNumber");
        missionName = intent.getStringExtra("missionName");
        launchDate = intent.getStringExtra("launchDate");
        launchwikiLink = intent.getStringExtra("launchwikiLink");
        launchVideolink = intent.getStringExtra("launchVideolink");
        //customerString = intent.getStringExtra("customerString");

        launchFlighttv.setText(flightNumber);
        launchMissiontv.setText(missionName);
        launchDatetv.setText(launchDate);
        launchWikitv.setText(launchwikiLink);
        launchVideotv.setText(launchVideolink);
        //launchcustomertv.setText(customerString);

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


    }
}
