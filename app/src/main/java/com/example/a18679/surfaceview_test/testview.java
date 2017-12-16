package com.example.a18679.surfaceview_test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by 18679 on 2017-12-3.
 */

public class testview extends View {
    private Scroller mscroller;
    private Bitmap mbitmap;
    private Paint mpaint;
    private int mleft;
    private int mright;
    private int mtop;
    private int mbottom;
    private int mwidth;
    private int mheigth;
    public testview(Context context) {
        this(context,null);
    }
    public testview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mpaint=new Paint();
        mpaint.setColor(Color.BLUE);
        mpaint.setTextSize(50);
        mbitmap=BitmapFactory.decodeResource(getResources(),R.drawable.a1);
        mscroller=new Scroller(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText("JOKER",100,100,mpaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void computeScroll() {
        if(mscroller.computeScrollOffset()){
            scrollTo(mscroller.getCurrX(),mscroller.getCurrY());
            postInvalidate();
        }
    }
    public void mscrollerTo(int X,int Y){
        int startX=getScrollX();
        int startY=getScrollY();
        int desX=X-startX;
        int desY=Y-startY;
        mscroller.startScroll(startX,startY,desX,desY,1000);
        invalidate();
    }
}
