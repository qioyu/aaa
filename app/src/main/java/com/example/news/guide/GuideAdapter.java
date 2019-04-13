package com.example.news.guide;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.news.R;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends PagerAdapter {

    List<ImageView> guideimageidlist = new ArrayList<>();

    public GuideAdapter(List<ImageView> imageList) {
        this.guideimageidlist = imageList;
    }

    @Override
    public int getCount() {
        return guideimageidlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(guideimageidlist.get(position));
        return guideimageidlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(guideimageidlist.get(position));
    }

}
