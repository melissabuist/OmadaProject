package com.example.omadaproject;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // creating variables for view pager,
    // liner layout, adapter and array list.
    private ViewPager viewPager;
    private LinearLayout dotsLL;
    private SliderAdapter adapter;
    private ArrayList<SliderModal> sliderModalArrayList;
    private TextView[] dots;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all views.
        viewPager = findViewById(R.id.idViewPager);
        dotsLL = findViewById(R.id.idLLDots);

        // in below line we are creating a new array list.
        sliderModalArrayList = new ArrayList<>();

        // hardcoding in the information that was provided for the project including quotes and authors
        //also includes url to a related royalty free image
        sliderModalArrayList.add(new SliderModal("\"Help me, Obi-Wan Kenobi. You’re my only hope.\"", "- Leia Organa", "https://images.unsplash.com/photo-1579566346927-c68383817a25?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"The Force will be with you. Always.\"", "- Obi-Wan Kenobi", "https://images.unsplash.com/photo-1533613220915-609f661a6fe1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1964&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"It’s the ship that made the Kessel run in less than twelve parsecs. I’ve outrun Imperial starships. Not the local bulk cruisers, mind you. I’m talking about the big Corellian ships, now. She’s fast enough for you, old man.\" ", "- Han Solo", "https://images.unsplash.com/photo-1627962996810-f682b4dd2b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"Do. Or do not. There is no try.\" ", "- Yoda", "https://images.unsplash.com/photo-1595139280770-95b6de5f0635?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1971&q=80", R.drawable.gradient_one));

        // add array list to adapter class.
        adapter = new SliderAdapter(MainActivity.this, sliderModalArrayList);


        // set adapter to our view pager.
        viewPager.setAdapter(adapter);

        //size of arraylist
        size = sliderModalArrayList.size();

        // add dots indicator
        addDots(size, 0);

        // call on page change listener method.
        viewPager.addOnPageChangeListener(viewListner);
    }

    private void addDots(int size, int pos) {
        // creating a new text view.
        dots = new TextView[size];


        dotsLL.removeAllViews();

        // for loop to add correct number of dots to our slider.
        for (int i = 0; i < size; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);

            // properties of the dots when not selected
            dots[i].setTextColor(getResources().getColor(R.color.black));
            dotsLL.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[pos].setTextColor(getResources().getColor(R.color.cyan_100));
        }
    }

    // creating a method for view pager for on page change listener.
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            // change the position of selected dots.
            addDots(size, position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
