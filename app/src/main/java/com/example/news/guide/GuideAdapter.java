package com.example.news.guide;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.news.R;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends PagerAdapter {

    List<Integer> guideimageidlist = new ArrayList<>();
    View.OnClickListener onClickListener;

    public void setonClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public GuideAdapter() {
        guideimageidlist.add(R.drawable.guide_1);
        guideimageidlist.add(R.drawable.guide_2);
        guideimageidlist.add(R.drawable.guide_3);
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

        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_guide, container, false);
        ImageView imageView = inflate.findViewById(R.id.guideImageView);
        imageView.setImageResource(guideimageidlist.get(position));
        Button button = inflate.findViewById(R.id.gui_button);
        if (position == guideimageidlist.size() - 1) {
            button.setVisibility(View.VISIBLE);
            if (onClickListener!=null){
                button.setOnClickListener(onClickListener);
            }
        } else {
            inflate.findViewById(R.id.gui_button).setVisibility(View.GONE);
        }
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
