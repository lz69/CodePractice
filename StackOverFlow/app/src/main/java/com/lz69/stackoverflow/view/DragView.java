package com.lz69.stackoverflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class DragView extends View{

    private int lastX;

    private int lastY;

    private Scroller mScroller;

    public DragView(Context context) {
        super(context);
        init();
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int)(event.getRawX());
        int rawY = (int)(event.getRawY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;

//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                ((View)getParent()).scrollBy(-offsetX, -offsetY);

                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = (View)getParent();
                mScroller.startScroll(viewGroup.getScrollX(), viewGroup.getScrollY(), -viewGroup.getScrollX(), -viewGroup.getScrollY());
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        mScroller.startScroll(startX, startY, dx, dy, 10000);
    }
}
