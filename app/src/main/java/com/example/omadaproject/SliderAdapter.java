package com.example.omadaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.omadaproject.R;
import com.example.omadaproject.SliderModal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {


    // creating variables for layout
    // inflater, context and array list.
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<SliderModal> sliderModalArrayList;

    // creating constructor.
    public SliderAdapter(Context context, ArrayList<SliderModal> sliderModalArrayList) {
        this.context = context;
        this.sliderModalArrayList = sliderModalArrayList;
    }

    @Override
    public int getCount() {
        // inside get count method returning
        // the size of our array list.
        return sliderModalArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // inside isViewFrombject method we are
        // returning our Relative layout object.
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // in this method we will initialize all our layout
        // items and inflate our layout file as well.
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        // inflates the layout we created
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        // initializing views.
        ImageView imageView = view.findViewById(R.id.idIV);
        TextView titleTV = view.findViewById(R.id.idTVtitle);
        TextView headingTV = view.findViewById(R.id.idTVheading);
        RelativeLayout sliderRL = view.findViewById(R.id.idRLSlider);

        // setting data to views.
        SliderModal modal = sliderModalArrayList.get(position);
        titleTV.setText(modal.getTitle());
        headingTV.setText(modal.getHeading());
        Picasso.get().load(modal.getImgUrl()).into(imageView);

        // setting background to a drawable
        sliderRL.setBackground(context.getResources().getDrawable(modal.getBackgroundDrawable()));

        // adding the view to our container.
        container.addView(view);

        // returning the view.
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // this is a destroy view method
        container.removeView((RelativeLayout) object);
    }
}
