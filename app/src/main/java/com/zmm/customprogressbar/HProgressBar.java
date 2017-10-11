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
    private int textMarginTop = 55;

    //进度条距上部高度
    private int barMarginTop = 80;



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
        canvas.drawRoundRect(new RectF(0,barMarginTop, mBarLength,size+barMarginTop),radian,radian, mPaintIn);

        mPaintOut.setColor(Color.GREEN);
        mPaintOut.setAntiAlias(true);
        mPaintOut.setStrokeWidth(2);
        canvas.drawRoundRect(new RectF(0,barMarginTop, mPercent * mBarLength,size+barMarginTop),radian,radian, mPaintOut);

        mPaintText.setColor(Color.RED);
        mPaintText.setTextSize(40);
        mPaintText.setAntiAlias(true);

        canvas.drawText("偏轻",0.20f* mBarLength,40,mPaintText);
        canvas.drawText("健康",0.50f*mBarLength,40,mPaintText);
        canvas.drawText("偏重",0.62f*mBarLength,40,mPaintText);
        canvas.drawText("超重",0.80f*mBarLength,40,mPaintText);

        mPaintText.setTextSize(20);
        canvas.drawText("18.5",0.46f* mBarLength,textMarginTop+barMarginTop,mPaintText);
        canvas.drawText("24",0.60f*mBarLength,textMarginTop+barMarginTop,mPaintText);
        canvas.drawText("28",0.70f*mBarLength,textMarginTop+barMarginTop,mPaintText);


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
