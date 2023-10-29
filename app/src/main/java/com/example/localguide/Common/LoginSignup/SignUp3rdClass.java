package com.example.localguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.example.localguide.R;

public class SignUp3rdClass extends AppCompatActivity {

    ScrollView scrollView;
    PinView pinView;

    ImageView imageView;
    TextView textView1,textView2,textView3;
    Button ver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3rd_class);

        //HOOKS

        imageView = findViewById(R.id.close_btn_t);
        textView1 = findViewById(R.id.otp_code_t);
        textView2 = findViewById(R.id.otp_verification_t);
        textView3 = findViewById(R.id.otp_description_t);
        pinView = findViewById(R.id.pin_view);
        ver = findViewById(R.id.verify_code);
        scrollView = findViewById(R.id.scroll_view);





    }

    public void callNextScreenFromOTP(View view){

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
//Add Transition
        Pair[] pairs = new Pair[1];

        //pairs[0] = new Pair<View, String>(imageView, "transtion_close_btn");
        //pairs[1] = new Pair<View, String>(textView1, "transition_otp_code_text");
        //pairs[2] = new Pair<View, String>(textView2, "transition_otp_verification");
        //pairs[3] = new Pair<View, String>(textView3, "transition_descripton");
        //pairs[4] = new Pair<View, String>(ver, "transition_OTP_screen");
        pairs[0] = new Pair<View, String>(scrollView, "transition_OTP_screen");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }



    }
}