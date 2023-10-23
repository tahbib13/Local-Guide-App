package com.example.localguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.localguide.R;
import com.example.localguide.User.UserDashBoard;

public class SplashScreen extends AppCompatActivity {

    private static int  SPLASH_TIMER = 5000;



    //variable
    ImageView backgroundImage;
    TextView poweredByLine , hi;

    //Animations

    Animation side_anim, bottom_anim;

    SharedPreferences onBoardingScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);


        //Animations

        side_anim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations on elements

        backgroundImage.setAnimation(side_anim);
        poweredByLine.setAnimation(bottom_anim);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);

                boolean isFirstTime = onBoardingScreen.getBoolean( "firstTime", true);


                if(isFirstTime){


                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean( "firsTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    Intent intent = new Intent(getApplicationContext(),UserDashBoard.class);
                    startActivity(intent);
                    finish();
                }



            }
        },SPLASH_TIMER);



    }
}