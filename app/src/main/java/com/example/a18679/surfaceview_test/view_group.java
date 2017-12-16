package com.example.a18679.surfaceview_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by 18679 on 2017-12-10.
 */

public class view_group extends ViewGroup {
    public view_group(Context context) {
        super(context);
    }
    public view_group(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
