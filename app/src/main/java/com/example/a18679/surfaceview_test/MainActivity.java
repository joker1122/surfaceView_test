package com.example.a18679.surfaceview_test;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Scroller;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll);
        final testview mtest=(testview)findViewById(R.id.mtestview);
        Button mbutton=(Button)findViewById(R.id.scrollbutton);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtest.mscrollerTo(mtest.getScrollX()-100,mtest.getScrollY()-200);
            }
        });
//        surface_view view=(surface_view)findViewById(R.id.surface_view);
//        view.setZOrderOnTop(true);
//        view.setZOrderMediaOverlay(true);
    }
}
