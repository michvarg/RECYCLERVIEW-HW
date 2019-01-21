package com.example.michell.homework0302;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "com.example.michell.homework0302.RecyclerViewAdapter" ;

    private ArrayList<String> mImageNames = new ArrayList<>(); //you don't need to instantiate ArrayList
    private ArrayList<String> mImages = new ArrayList<>(); //see above
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> imagaNames, ArrayList<String> images, Context context) {
        mImageNames = imagaNames;
        mImages = images;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

//        ViewGroup parent = null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listthings, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBingViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(viewHolder.image);

        viewHolder.imageName.setText(mImageNames.get(position));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT). show();

            }
        });

    }

    @Override
    public int getItemCount() {

        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        CardView imageCardview;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            imageCardview = itemView.findViewById(R.id.image_card_view);

            imageCardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendNotification();
                }

                private void sendNotification() {
                }


            });

        }
    }

}
