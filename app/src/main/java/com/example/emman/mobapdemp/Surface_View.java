package com.example.emman.mobapdemp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Surface_View extends AppCompatActivity implements View.OnTouchListener{

    ourView v;
    Bitmap ball;
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new ourView(this);
        v.setOnTouchListener(this);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.brazuca);
        x = y = 0;
        setContentView(v);

    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }



    public class ourView extends SurfaceView implements Runnable{

        Thread t = null;
        SurfaceHolder holder;
        boolean isOk = false;

        public ourView(Context context) {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {
            while(isOk){
                if(!holder.getSurface().isValid()){
                    continue;
                }

                Canvas c = holder.lockCanvas();
                c.drawARGB(255, 150, 150, 10);
                c.drawBitmap(ball, x - ball.getWidth()/2, y - ball.getHeight()/2, null);
                holder.unlockCanvasAndPost(c);

            }

        }

        public void pause(){
            isOk = false;
            while(true){
                try{
                    t.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = null;
        }

        public void resume(){
            isOk = true;
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent me) {
        x = me.getX();
        y = me.getY();

        switch (me.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = me.getX();
                y = me.getY();
            break;
            case MotionEvent.ACTION_UP:
                x = me.getX();
                y = me.getY();
            break;
            case MotionEvent.ACTION_MOVE:
                x = me.getX();
                y = me.getY();
                break;
        }
        return true;
    }
}
