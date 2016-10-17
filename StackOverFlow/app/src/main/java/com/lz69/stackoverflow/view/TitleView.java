package com.lz69.stackoverflow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lz69.stackoverflow.R;

public class TitleView extends RelativeLayout {

    protected final float SCALE = getContext().getResources().getDisplayMetrics().density;

    private Context mContext = getContext();

    private String mTitle;

    private float mTitleTextSize;

    private int mTitleTextColor;

    private int mLeftTextColor;

    private String mLeftText;

    private int mRightTextColor;

    private String mRightText;

    private TextView mLeftTextView;

    private TextView mRightTextView;

    private TextView mTitleTextView;

    private LayoutParams mLeftParams;

    private LayoutParams mRightParams;

    private LayoutParams mTitleParams;

    private TitleViewClickListener mTitleViewClickListener;

    public TitleView(Context context) {
        super(context);
        init();
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(attrs);
        init();
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(attrs);
        init();
    }

    private void init() {
        mLeftTextView = new TextView(mContext);
        mRightTextView = new TextView(mContext);
        mTitleTextView = new TextView(mContext);

        mLeftTextView.setText(mLeftText);
        mLeftTextView.setTextColor(mLeftTextColor);

        mRightTextView.setText(mRightText);
        mRightTextView.setTextColor(mRightTextColor);

        mTitleTextView.setText(mTitle);
        mTitleTextView.setTextColor(mTitleTextColor);
        mTitleTextView.setTextSize(mTitleTextSize / SCALE);
        mTitleTextView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftTextView, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightTextView, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleTextView, mTitleParams);

        mLeftTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleViewClickListener.leftClick();
            }
        });

        mRightTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleViewClickListener.rightClick();
            }
        });
    }

    private void initAttributeSet(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TitleView);
        mTitle = ta.getString(R.styleable.TitleView_title);
        mTitleTextSize = ta.getDimension(R.styleable.TitleView_titleTextSize, 10f);
        mTitleTextColor = ta.getColor(R.styleable.TitleView_titleTextColor, 0);
        mLeftTextColor = ta.getColor(R.styleable.TitleView_leftTextColor, 0);
        mLeftText = ta.getString(R.styleable.TitleView_leftText);
        mRightTextColor = ta.getColor(R.styleable.TitleView_rightTextColor, 0);
        mRightText = ta.getString(R.styleable.TitleView_rightText);
        ta.recycle();
    }

    public void setOnTitleViewClickListener(TitleViewClickListener titleViewClickListener) {
        this.mTitleViewClickListener = titleViewClickListener;
    }
    public interface TitleViewClickListener {
        void leftClick();
        void rightClick();
    }

}
