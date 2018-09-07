package com.meiquick.vitimageload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.meiquick.imageload.MImageLoader;
import com.meiquick.imageload.config.ImageConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MImageLoader.init(this, 10);

        ImageView image = findViewById(R.id.image);

        new ImageConfig.Builder(this)
//                .errorId(R.drawable.ic_error)
                .asCircle()
                .url("http://p0.ifengimg000.com/pmop/2018/0906/D13E8623F6CDAC87FFF305863723AEEF91512A90_size126_w1080_h720.jpeg").into(image);

        ImageView imageBg = findViewById(R.id.image_bt);
        new ImageConfig.Builder(this)
                .errorId(R.drawable.ic_error)
                .centerCrop()
                .blur(15)
                .url("http://p0.ifengimg000.com/pmop/2018/0906/D13E8623F6CDAC87FFF305863723AEEF91512A90_size126_w1080_h720.jpeg").into(imageBg);

    }
}
