package eatda.TeamProject_EatDa_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation anim_FadeIn;
    Animation anim_ball;
    ConstraintLayout constraintLayout;
    TextView tv1, tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.constraintLayout);
        tv1=findViewById(R.id.kname);
        tv2=findViewById(R.id.Ename);

        anim_FadeIn= AnimationUtils.loadAnimation(this, R.anim.anim_splash_fadein);
        anim_ball= AnimationUtils.loadAnimation(this, R.anim.anim_splash_ball);


        anim_FadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        tv1.startAnimation(anim_FadeIn);
        tv2.startAnimation(anim_ball);


    }
}