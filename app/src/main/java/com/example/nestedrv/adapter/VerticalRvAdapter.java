package com.example.nestedrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrv.Model.HorizontalModel;
import com.example.nestedrv.Model.VerticalModel;
import com.example.nestedrv.R;

import java.util.ArrayList;

public class VerticalRvAdapter extends RecyclerView.Adapter<VerticalRvAdapter.VerticalViewHolder> {

    Context context ;
    ArrayList<VerticalModel> verticalModelsarraylist ;

    public  VerticalRvAdapter(Context context , ArrayList<VerticalModel> verticalModelArrayList){
        this.context = context ;
        this.verticalModelsarraylist = verticalModelArrayList;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical , parent , false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        VerticalModel verticalModel = verticalModelsarraylist.get(position);
        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleITem = verticalModel.getHorizontalModelArrayList();


        holder.tvTitle1.setText(title);

        HorizontalRvAdapter  horizontalRvAdapter = new HorizontalRvAdapter(context , singleITem);

        holder.rv1.setHasFixedSize(true);
        holder.rv1.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false));

        holder.rv1.setAdapter(horizontalRvAdapter);

    }

    @Override
    public int getItemCount() {
        return verticalModelsarraylist.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle1 ;
        RecyclerView rv1;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle1 = itemView.findViewById(R.id.title1);
            rv1 = itemView.findViewById(R.id.rv1);
        }
    }
}
