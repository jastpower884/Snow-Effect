package com.jastzeonic.snoweffect.view.item;

import android.graphics.Paint;

/**
 * The item which draw on canvas items.
 * Created by jast.lai on 21/12/2017.
 */

public abstract class AbstractItem {

    private Paint paint = new Paint();  // 繪製樣式物件
    private int circlePointX = 0;
    private int circlePointY = 0;
    private int viewHeight = 0;
    private int viewWidth = 0;

    private boolean isDisplay = false;


    public int getCirclePointX() {
        return circlePointX;
    }

    public void setCirclePointX(int circlePointX) {
        this.circlePointX = circlePointX;
    }

    public int getCirclePointY() {
        return circlePointY;
    }

    public void setCirclePointY(int circlePointY) {
        this.circlePointY = circlePointY;
    }

    public int getViewHeight() {
        return viewHeight;
    }

    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }

    public int getViewWidth() {
        return viewWidth;
    }

    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    public Paint getPaint() {
        return paint;
    }

    public abstract void fallDown();

    public abstract void drift();


    public abstract int getSize();

    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }
}
