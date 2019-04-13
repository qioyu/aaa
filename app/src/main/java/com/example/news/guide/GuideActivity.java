package com.example.news.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.news.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager guideViewpager;
    List<ImageView> ImageList = new ArrayList<>();
    private ImageView redDotView;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();

        GuideAdapter adapter = new GuideAdapter(ImageList);
        guideViewpager.setAdapter(adapter);
        guideViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //当前位置：position，百分比：positionOffset，移动距离：positionOffsetPixels
//                Log.e("--------", position + ":" + positionOffset + ":" + positionOffsetPixels);
//                int width = rl.getMeasuredWidth();
////                Log.e("--------",width+"" );
//                int w = width / 3;
////                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams();
//                Log.e("--------", (w*positionOffset + position)+10 + "");
//                redDotView.setTranslationX((w*positionOffset + position)+10);
                position = position % ImageList.size();
                float leftMargin = 65 * (position + positionOffset);
                redDotView.setTranslationX(leftMargin);
                Log.d("红点在这", leftMargin + "");
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    //调用addImage，这样少new 几个ImageView
    private void initData() {
        addImage(R.drawable.guide_1);
        addImage(R.drawable.guide_2);
        addImage(R.drawable.guide_3);
    }

    private void initView() {
        guideViewpager = (ViewPager) findViewById(R.id.guideViewpager);
        redDotView = (ImageView) findViewById(R.id.redDotView);
        rl = (RelativeLayout) findViewById(R.id.rl);
    }

    //把guide_1,2,3存入Imageview在存入Arrlist中
    public void addImage(int id) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(id);
        ImageList.add(imageView);
    }
}
