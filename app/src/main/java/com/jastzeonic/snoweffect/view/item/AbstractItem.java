package com.jastzeonic.snoweffect.view.item;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * The item which draw on canvas items.
 * Created by jast.lai on 21/12/2017.
 */

public abstract class AbstractItem {

    private Paint paint = new Paint();  // 繪製樣式物件
    private Path path = new Path(); // 繪製路徑
    private int pointX = 0;
    private int pointY = 0;
    private int viewHeight = 0;
    private int viewWidth = 0;

    private boolean isDisplay = false;

    AbstractItem() {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);

    }


    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
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

    public Path getPath() {
        return path;
    }
}
