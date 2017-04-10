package com.michrosys.richard.ghostmodechatapp;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.michrosys.richard.ghostmodechatapp.ui.Login;
import com.michrosys.richard.ghostmodechatapp.ui.Register;

import java.util.Locale;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
  TextView logotext,goghost;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_first);

        AssetManager am = getApplicationContext().getAssets();
       Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "adrip1.ttf"));
        logotext = (TextView) findViewById(R.id.logoText);
        goghost = (TextView) findViewById(R.id.goghost);
        logotext.setTypeface(typeface);
        goghost.setTypeface(typeface);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    public void openFragment2(Fragment frag, int containerId){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(containerId,frag);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login:
                Log.i("burn", "I was clicked");
                Fragment login = new Login();
                openFragment2(login,R.id.ContainerMain);
                break;
            case R.id.register:
                Fragment register = new Register();
                openFragment2(register,R.id.ContainerMain);
                break;
        }
    }
}
