package com.example.news.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.news.R;
import com.example.news.base.BaseActivity;
import com.example.news.guide.GuideActivity;

public class SplashActivity extends BaseActivity {

    private ImageView animation_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
//        setanimationSet(animation_image);
        setanimatorSet(animation_image);
    }

    //封装方法区
    private void setanimatorSet(ImageView animation_image) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator rotation = ObjectAnimator.ofFloat(animation_image, "rotation", 0, 1080);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(animation_image, "scaleX", 0, 1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(animation_image, "scaleY", 0, 1);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(animation_image, "alpha", 0, 1);
        animatorSet.setDuration(3000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(context, GuideActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        });
        animatorSet.playTogether(rotation,scaleX,scaleY,alpha);
        animatorSet.start();

    }

    private void setanimationSet(ImageView animation_image) {
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotate = new RotateAnimation(0, 1080, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alpha = new AlphaAnimation(0, 1f);

        animationSet.addAnimation(rotate);
        animationSet.addAnimation(scale);
        animationSet.addAnimation(alpha);

        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        animation_image.setAnimation(animationSet);
        animationSet.start();
    }

    private void initView() {
        animation_image = (ImageView) findViewById(R.id.animation_image);
    }
}
