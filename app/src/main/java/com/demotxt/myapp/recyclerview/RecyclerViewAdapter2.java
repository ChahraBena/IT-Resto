package com.demotxt.myapp.recyclerview;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter2(Context context, ArrayList<String> imageNames, ArrayList<String> images , ArrayList<String> imageDesc) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        mDesc=imageDesc;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.imageDesc.setText(mDesc.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

              //  Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, FoodDelivery.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
            }
        });
        holder.but_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.valueOf("Ajouté aux favorites"), Toast.LENGTH_SHORT).show();
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
        TextView imageDesc;
        RelativeLayout parentLayout;
        Button but_star;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageDesc = itemView.findViewById(R.id.image_desc);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            but_star = itemView.findViewById(R.id.imageButtonSelector);

        }
    }
}
