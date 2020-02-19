package com.ppal007.recyclerviewhorizontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;


import com.ppal007.recyclerviewhorizontal.databinding.ActivityGalleryBinding;

public class GalleryActivity extends AppCompatActivity {
    private ActivityGalleryBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(GalleryActivity.this, R.layout.activity_gallery);

//        get image and string from recyclerViewAdapter
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int image = bundle.getInt("ex_logo");
            String name = bundle.getString("ex_name");

            setImageName(image, name);
        }


    }


    private void setImageName(int image, String name) {
//        set image in image view
        binding.imageViewGallery.setImageResource(image);
//        set string to text view
        binding.tvGallery.setText(name);
    }


}
