package com.demotxt.myapp.recyclerview;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by RinonymousRi on 1/11/2018.
 */

public class FoodDeliverAdapter  extends RecyclerView.Adapter<FoodDeliverAdapter.ViewHolder>{


    private Context mContext;
    private ArrayList<FoodModel> mList;
    public FoodDeliverAdapter(Context context, ArrayList<FoodModel> list){
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.rv_items, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FoodModel contact = mList.get(position);

        // Set item views based on your views and data model
        TextView item_name = holder.item_name;
        TextView item_place = holder.item_place;
        TextView item_price = holder.item_price;
        ImageView item_img = holder.item_image;

        item_name.setText(contact.getItem_name());
        item_place.setText(contact.getItem_place());
        item_price.setText(contact.getItem_price());
        item_img.setImageResource(contact.getItem_image());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, AddBasket.class);

                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView item_image;
        public TextView item_name,item_place,item_price;
        public CardView cardView;
        public Button but_star;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
//
            item_image = itemView.findViewById(R.id.rv_item_img);
            item_name = itemView.findViewById(R.id.rv_item_name);
            item_place = itemView.findViewById(R.id.rv_item_place);
            item_price = itemView.findViewById(R.id.rv_item_price);
            cardView = itemView.findViewById(R.id.rv_card);

        }
    }
}
