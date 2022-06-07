package com.example.nestedrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrv.Model.HorizontalModel;
import com.example.nestedrv.Model.VerticalModel;
import com.example.nestedrv.R;

import java.util.ArrayList;

public  class HorizontalRvAdapter  extends RecyclerView.Adapter<HorizontalRvAdapter.VVHolder> {

        Context context ;
       ArrayList<HorizontalModel> horizontalModelArrayList ;

        public  HorizontalRvAdapter(Context context , ArrayList<HorizontalModel> horizontalModelArrayList){
            this.context = context ;
           this.horizontalModelArrayList = horizontalModelArrayList;
        }


    @NonNull
    @Override
    public HorizontalRvAdapter.VVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal , parent ,false);
      return new VVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VVHolder holder, int position) {

            final HorizontalModel horizontalModel = horizontalModelArrayList.get(position);
            String title = horizontalModel.getName();

            holder.tvMainTitle.setText(title);
            holder.tvMainTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, horizontalModel.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalModelArrayList.size();
        }

        public class VVHolder extends RecyclerView.ViewHolder {

            TextView tvMainTitle ;


            public VVHolder(@NonNull View itemView) {
                super(itemView);
                tvMainTitle = itemView.findViewById(R.id.tv_main_title);

            }
        }


}
