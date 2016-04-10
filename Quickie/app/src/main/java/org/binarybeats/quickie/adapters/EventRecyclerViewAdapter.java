package org.binarybeats.quickie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.models.Event;

import java.util.ArrayList;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventRecyclerViewViewHolder> {

    private Context mContext;
    private ArrayList<Event> mEvents;

    public EventRecyclerViewAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mEvents = events;
    }

    @Override
    public EventRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventRecyclerViewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mEvents.get(position).getEventImage())
                .fit()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mEventImage);
        holder.mEventName.setText(mEvents.get(position).getEventName());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private ImageView mEventImage;
        private TextView mEventName;

        public EventRecyclerViewViewHolder(View itemView) {
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.event_image);
            mEventName = (TextView) itemView.findViewById(R.id.event_name);
        }
    }
}