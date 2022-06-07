package com.example.nestedrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedrv.Model.HorizontalModel;
import com.example.nestedrv.Model.VerticalModel;
import com.example.nestedrv.adapter.VerticalRvAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvVertical ;
    ArrayList<VerticalModel> verticalModelsarraylist ;
    VerticalRvAdapter verticalRvAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVertical = findViewById(R.id.rv_vertical);
        verticalModelsarraylist = new ArrayList<>();
        rvVertical.setHasFixedSize(true);

        rvVertical.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));


        verticalRvAdapter = new VerticalRvAdapter(this ,verticalModelsarraylist );
        rvVertical.setAdapter(verticalRvAdapter);


        setData();
    }

    private void setData() {
        for (int i=1 ; i<=5 ; i++){
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTitle("TITLE: "+ i);
            ArrayList<HorizontalModel> horizontalModelArrayList = new ArrayList<>();

            for (int j=0 ; j<5 ; j++){
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setName("name "+j );
                horizontalModel.setDescription("description "+j );
                horizontalModelArrayList.add(horizontalModel);
            }
            verticalModel.setHorizontalModelArrayList(horizontalModelArrayList);
            verticalModelsarraylist.add(verticalModel);
        }
        verticalRvAdapter.notifyDataSetChanged();
    }
}
