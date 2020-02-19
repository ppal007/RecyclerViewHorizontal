package com.ppal007.recyclerviewhorizontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ppal007.recyclerviewhorizontal.adapter.RecyclerViewAdapter;
import com.ppal007.recyclerviewhorizontal.databinding.ActivityMainBinding;
import com.ppal007.recyclerviewhorizontal.model.Model1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private int[] logo;
    private String[] team;

    private ArrayList<Model1> model1s;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

//        initialize logo
        logo = new int[]{
                R.drawable.afganisthan,
                R.drawable.australia,
                R.drawable.bangladesh,
                R.drawable.england,
                R.drawable.india,
                R.drawable.pakistan,
                R.drawable.sauth_africa,
                R.drawable.srilanka,
                R.drawable.zimbabua,
                R.drawable.westindis
        };
//        initialize team_list
        team = getResources().getStringArray(R.array.team_list);

//        initialize array list
        model1s = new ArrayList<>();
        for (int i = 0; i < logo.length; i++) {
            Model1 model1 = new Model1(logo[i], team[i]);
            model1s.add(model1);
        }

//        initialize horizontal design
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                RecyclerView.HORIZONTAL,
                false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());

//        initialize adapter
        adapter = new RecyclerViewAdapter(model1s, MainActivity.this);
//        set adapter to recycler view
        binding.recyclerView.setAdapter(adapter);
    }
}
