package com.lz69.stackoverflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class ViewGroup_1 extends ViewGroup {

    private int mScreenHeight;

    private int mStart;

    private int mEnd;

    private Scroller mScroller;

    private int mLastY;

    public ViewGroup_1(Context context) {
        super(context);
        init();
    }

    public ViewGroup_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewGroup_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScreenHeight = 1000;
        mScroller = new Scroller(getContext());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                child.layout(l, i * mScreenHeight, r, (i + 1) * mScreenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if(getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreenHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScollY = mEnd - mStart;
                if (dScollY > 0) {
                    if( dScollY < mScreenHeight / 3) {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, -dScollY
                        );
                    } else {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, mScreenHeight - dScollY
                        );
                    }
                } else {
                    if (-dScollY < mScreenHeight / 3) {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, -dScollY
                        );
                    } else {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, -mScreenHeight - dScollY
                        );
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }
}
