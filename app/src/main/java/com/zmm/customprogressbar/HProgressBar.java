package com.zmm.customprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/10/10
 * Time:下午4:37
 */

public class HProgressBar extends View {

    private Paint mPaintIn;
    private Paint mPaintOut;
    private Paint mPaintText;

    //进度条长度
    private int mBarLength = 1000;
    //进度条百分比
    private float mPercent = 0;

    //进度条弧度
    private int radian = 20;
    //进度条尺寸
    private int size = 30;
    //字体距上部高度
    private int textMarginTop = 60;



    public HProgressBar(Context context) {
        this(context,null);
    }

    public HProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaintIn = new Paint();
        mPaintOut = new Paint();
        mPaintText = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("---onDraw---");
        mPaintIn.setColor(Color.BLUE);
        mPaintIn.setAntiAlias(true);
        mPaintIn.setStrokeWidth(2);
        canvas.drawRoundRect(new RectF(0,0, mBarLength,size),radian,radian, mPaintIn);

        mPaintOut.setColor(Color.GREEN);
        mPaintOut.setAntiAlias(true);
        mPaintOut.setStrokeWidth(2);
        canvas.drawRoundRect(new RectF(0,0, mPercent * mBarLength,size),radian,radian, mPaintOut);

        mPaintText.setColor(Color.RED);
        mPaintText.setTextSize(20);
        mPaintText.setAntiAlias(true);
        canvas.drawText("0",0,textMarginTop,mPaintText);
        canvas.drawText("12",0.12f* mBarLength,textMarginTop,mPaintText);
        canvas.drawText("32",0.32f*mBarLength,textMarginTop,mPaintText);
        canvas.drawText("67",0.67f*mBarLength,textMarginTop,mPaintText);
        canvas.drawText("100",mBarLength,textMarginTop,mPaintText);


    }


    public void setBarLength(int barLength) {
        mBarLength = barLength;
    }


    public void setPercent(float percent) {
        mPercent = percent;
        invalidate();
    }

    public void setRadian(int radian) {
        this.radian = radian;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTextMarginTop(int textMarginTop) {
        this.textMarginTop = textMarginTop;
    }
}
