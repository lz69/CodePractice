package com.lz69.stackoverflow.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class View_2 extends View{

    private float mWidth;

    private float mHeight;

    public View_2(Context context) {
        super(context);
    }

    public View_2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View_2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth() - 2;
        mHeight = getHeight() - 2;
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.BLACK);
        paintCircle.setStrokeWidth(2);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, paintCircle);

        Paint paintDegree = new Paint();
        paintCircle.setStrokeWidth(3);
        paintDegree.setColor(Color.BLACK);
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, mWidth / 2 - paintDegree.measureText(degree) / 2, mHeight / 2 - mWidth / 2 + 90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 30, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, mWidth / 2 - paintDegree.measureText(degree) / 2, mHeight / 2 - mWidth /2 + 60, paintDegree);
            }
            canvas.rotate(15, mWidth / 2, mHeight / 2);
        }
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(10);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(5);
        canvas.save();
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(0, 0, 50, 50, paintHour);
        canvas.drawLine(0, 0, 50, 100, paintMinute);
        canvas.restore();
    }
}
