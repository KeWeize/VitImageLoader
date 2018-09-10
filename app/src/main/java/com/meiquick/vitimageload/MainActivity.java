package com.meiquick.vitimageload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.meiquick.imageload.MImageLoader;
import com.meiquick.imageload.config.GlobalConfig;
import com.meiquick.imageload.config.ImageConfig;
import com.meiquick.imageload.loader.GlideLoader;

public class MainActivity extends AppCompatActivity {

    TextView tvCacheSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image01 = findViewById(R.id.test01);
        ImageView image02 = findViewById(R.id.test02);
        ImageView image03 = findViewById(R.id.test03);
        ImageView image04 = findViewById(R.id.test04);
        ImageView image05 = findViewById(R.id.test05);

        MImageLoader.with(this).res(R.drawable.test01).into(image01);

        MImageLoader.with(this).url("http://pic1.win4000.com/wallpaper/2017-12-04/5a24c0e98479b.jpg")
//                .withCrossFade()
                .asCircle()
//                .centerCrop()
                .into(image02);

        MImageLoader.with(this).asserts("test03.jpg").into(image03);

        MImageLoader.with(this).res(R.drawable.testgif).into(image04);

        MImageLoader.with(this).raw(R.raw.test05).into(image05);

    }
}
