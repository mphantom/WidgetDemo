package com.mphantom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by mphantom on 17/1/22.
 */

public class DrawableCenterTextView extends TextView {
    private final static String TAG = DrawableCenterTextView.class.getSimpleName();

    public DrawableCenterTextView(Context context) {
        super(context);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables[0] != null) {
            Drawable drawableLeft = drawables[0];
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = 0;
            drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
            Log.d(TAG, "viewWidth==" + getWidth());
            Log.d(TAG, "drawablePadding==" + drawablePadding);
            Log.d(TAG, "drawableWidth==" + drawableWidth);
            Log.d(TAG, "textWidth==" + textWidth);
        }
        if (drawables[1] != null) {
            Drawable drawableTop = drawables[1];
            Paint.FontMetrics fm = getPaint().getFontMetrics();
            float textHeight = (float) (Math.ceil(fm.descent - fm.top));
            int drawablePadding = getCompoundDrawablePadding();
            int drawableHeight = 0;
            drawableHeight = drawableTop.getIntrinsicHeight();
            float bodyHeight = textHeight + drawableHeight + drawablePadding;
            canvas.translate(0, (getHeight() - bodyHeight) / 2);
            Log.d(TAG, "viewHeight==" + getHeight());
            Log.d(TAG, "drawablePadding==" + drawablePadding);
            Log.d(TAG, "drawableHeight==" + drawableHeight);
            Log.d(TAG, "textHeight==" + textHeight);
        }
        if (drawables[2] != null) {
            Drawable drawableRight = drawables[2];
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = 0;
            drawableWidth = drawableRight.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        if (drawables[3] != null) {
            Drawable drawableBottom = drawables[3];
            Paint.FontMetrics fm = getPaint().getFontMetrics();
            float textHeight = (float) (Math.ceil(fm.descent - fm.top));
            int drawablePadding = getCompoundDrawablePadding();
            int drawableHeight = 0;
            drawableHeight = drawableBottom.getIntrinsicHeight();
            float bodyHeight = textHeight + drawablePadding + drawableHeight;
            canvas.translate(0, (getHeight() - bodyHeight) / 2);
        }
        super.onDraw(canvas);
    }
}

