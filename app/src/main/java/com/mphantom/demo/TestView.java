package com.mphantom.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by mphantom on 2017/2/7.
 */

public class TestView extends android.support.v7.widget.AppCompatImageView {
    private final PorterDuffXfermode porterDuffXfermode;
    private Bitmap bitmap;
    private Paint mPaint;
    RectF rectF;
    private int width,height;

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
        int radio = w > h ? w : h;
        rectF = new RectF(0, 0, radio, radio);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sc = canvas.saveLayer(0, 0, width, height, null, Canvas.ALL_SAVE_FLAG);
        // 先绘制dis目标图
        canvas.drawArc(rectF, 144, 252, true, mPaint);

        // 设置混合模式
        mPaint.setXfermode(porterDuffXfermode);
        // 再绘制src源图
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        // 还原混合模式
        mPaint.setXfermode(null);
        // 还原画布
        canvas.restoreToCount(sc);


    }
}
