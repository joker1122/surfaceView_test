package com.example.a18679.surfaceview_test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by 18679 on 2017-11-27.
 */

public class surface_view extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private mythread my_thread;
    private gesture gesture;
    private GestureDetector gestureDetector;
    public surface_view(Context context) {
        this(context,null);
    }

    public surface_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        gesture=new gesture();
        gestureDetector=new GestureDetector(context,gesture);
        holder=getHolder();
        holder.addCallback(this);
        my_thread=new mythread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
//        int action=event.getAction();
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                Log.d("get","x="+event.getX()+"y="+event.getY());
//                break;
//        }
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        my_thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    public void draw_surface(Canvas canvas){
//        Bitmap bitmap= BitmapFactory.decodeFile("a1.jpg");
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(100);
        canvas.drawText("hello joker",100,600,paint);
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
    class gesture implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }
        @Override
        public void onShowPress(MotionEvent e) {

        }
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("get","X msg:"+e.getX());
            return true;
        }
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return true;
        }
        @Override
        public void onLongPress(MotionEvent e) {

        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("get","onFling");
            return true;
        }
    }
    class mythread extends Thread{
        private SurfaceHolder holder;
        private Canvas canvas;
        public mythread(SurfaceHolder holder){
            this.holder=holder;
        }
        public void run(){
            try{
                synchronized (holder){
                    canvas=holder.lockCanvas();
                    if(canvas!=null) {
                        draw_surface(canvas);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
