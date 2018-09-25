package learning.spacex.com.futureinskies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


import learning.spacex.com.futureinskies.DateUtils;
import learning.spacex.com.futureinskies.R;
import learning.spacex.com.futureinskies.models.Launches;


public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {


    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    // we define a list from the DevelopersList java class

    private List<Launches> launchesLists;
    private Context context;
    private OnItemClickListener listener;

    public LaunchesAdapter(List<Launches> launchesLists, Context context, OnItemClickListener listener) {
        this.launchesLists = launchesLists;
        this.context = context;
        this.listener= listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.launches_list, parent, false);
        return new ViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        Launches launch = launchesLists.get(position);
        holder.missonName.setText(launch.getMissionName());
        holder.launchdate.setText("at "+DateUtils.convertUnixdateToString(launch.getLaunchDateUnix()));
        holder.sitename.setText("in "+launch.getLaunchSite().getSiteName());

        Picasso.with(context)
                .load(launch.getLinks().getMissionPatchSmall())
                .into(holder.image_url);
    }

    @Override

    //return the size of the listItems (developersList)

    public int getItemCount() {
        return launchesLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        // define the View objects

        public TextView missonName;
        public ImageView image_url;
        public TextView launchdate;
        public TextView sitename;
        public TextView launchsuccess;
        public LinearLayout linearLayout;
        OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);

            // initialize the View objects

            missonName = (TextView) itemView.findViewById(R.id.missionname);
            image_url = (ImageView) itemView.findViewById(R.id.imageView);
            launchdate = (TextView) itemView.findViewById(R.id.launchdate);
            sitename = (TextView) itemView.findViewById(R.id.sitename);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            this.onItemClickListener=onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int item);
    }
}