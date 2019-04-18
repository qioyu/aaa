package com.example.news.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.news.R;
import com.example.news.translate.translateActivity;
import com.example.news.utils.Preferencesutils;

public class GuideActivity extends AppCompatActivity {

    private ViewPager guideViewpager;
    private ImageView redDotView;
    private RelativeLayout rl;
    float distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();

        GuideAdapter adapter = new GuideAdapter();
        guideViewpager.setAdapter(adapter);
        guideViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                gitDotDistance(rl);
                float v = (positionOffset + position) * distance;
                redDotView.setTranslationX(v);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        adapter.setonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferencesutils.putBoolean("splash",false);
                Intent intent = new Intent(GuideActivity.this, translateActivity.class);
                startActivity(intent);
                GuideActivity.this.finish();
            }
        });
    }

    //获取点与点之间的距离
    public void gitDotDistance(final RelativeLayout rl) {
        this.rl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                View childAt0 = rl.getChildAt(0);
                View childAt1 = rl.getChildAt(1);
                distance = childAt1.getX() - childAt0.getX();
            }
        });
    }

    private void initView() {
        guideViewpager = (ViewPager) findViewById(R.id.guideViewpager);
        redDotView = (ImageView) findViewById(R.id.redDotView);
        rl = (RelativeLayout) findViewById(R.id.rl);
    }

}
