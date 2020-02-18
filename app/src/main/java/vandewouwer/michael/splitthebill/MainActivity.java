package vandewouwer.michael.splitthebill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


import vandewouwer.michael.splitthebill.Utils.TabPagerAdapter;
import vandewouwer.michael.splitthebill.Utils.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //verwijzen naar componenten in UI
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.frag_container);

        //omschrijving hoe alles opgevuld moet worden
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(), 0);
        //alles instellen
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
    }
}
