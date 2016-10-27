package com.lz69.stackoverflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ListView_1 extends ListView {

    private final int mMaxOverDistance = (int) getContext().getResources().getDisplayMetrics().density * 100;

    public ListView_1(Context context) {
        super(context);
    }

    public ListView_1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListView_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}
