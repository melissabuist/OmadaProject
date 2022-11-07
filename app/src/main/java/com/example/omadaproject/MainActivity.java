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
    // liner layout, adapter and our array list.
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

        // initializing all our views.
        viewPager = findViewById(R.id.idViewPager);
        dotsLL = findViewById(R.id.idLLDots);

        // in below line we are creating a new array list.
        sliderModalArrayList = new ArrayList<>();

        // on below 3 lines we are adding data to our array list.
        sliderModalArrayList.add(new SliderModal("\"Help me, Obi-Wan Kenobi. You’re my only hope.\"", "- Leia Organa", "https://images.unsplash.com/photo-1579566346927-c68383817a25?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"The Force will be with you. Always.\"", "- Obi-Wan Kenobi", "https://images.unsplash.com/photo-1533613220915-609f661a6fe1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1964&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"It’s the ship that made the Kessel run in less than twelve parsecs. I’ve outrun Imperial starships. Not the local bulk cruisers, mind you. I’m talking about the big Corellian ships, now. She’s fast enough for you, old man.\" ", "- Han Solo", "https://images.unsplash.com/photo-1627962996810-f682b4dd2b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80", R.drawable.gradient_one));
        sliderModalArrayList.add(new SliderModal("\"Do. Or do not. There is no try.\" ", "- Yoda", "https://images.unsplash.com/photo-1595139280770-95b6de5f0635?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1971&q=80", R.drawable.gradient_one));

        // below line is use to add our array list to adapter class.
        adapter = new SliderAdapter(MainActivity.this, sliderModalArrayList);


        // below line is use to set our
        // adapter to our view pager.
        viewPager.setAdapter(adapter);

        // we are storing the size of our
        // array list in a variable.
        size = sliderModalArrayList.size();

        // calling method to add dots indicator
        addDots(size, 0);

        // below line is use to call on
        // page change listener method.
        viewPager.addOnPageChangeListener(viewListner);
    }

    private void addDots(int size, int pos) {
        // inside this method we are
        // creating a new text view.
        dots = new TextView[size];

        // below line is use to remove all
        // the views from the linear layout.
        dotsLL.removeAllViews();

        // running a for loop to add
        // number of dots to our slider.
        for (int i = 0; i < size; i++) {
            // below line is use to add the
            // dots and modify its color.
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);

            // below line is called when the dots are not selected.
            dots[i].setTextColor(getResources().getColor(R.color.black));
            dotsLL.addView(dots[i]);
        }
        if (dots.length > 0) {
            // this line is called when the dots
            // inside linear layout are selected
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
            // we are calling our dots method to
            // change the position of selected dots.
            addDots(size, position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
