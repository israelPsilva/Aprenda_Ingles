package com.example.aprendaingls.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aprendaingls.Fragments.AnimalsFragment;
import com.example.aprendaingls.Fragments.NumbersFragment;
import com.example.aprendaingls.Fragments.VowelsFragment;
import com.example.aprendaingls.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        getSupportActionBar().setElevation( 0 );

        smartTabLayout = findViewById( R.id.smartTabLayout );
        viewPager = findViewById( R.id.viewPager );

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Animais", AnimalsFragment.class )
                .add("Números", NumbersFragment.class )
                .add("Vogais", VowelsFragment.class )
                .create());

        viewPager.setAdapter( adapter );
        smartTabLayout.setViewPager(viewPager);
    }

}