package com.jastzeonic.snoweffect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jastzeonic.snoweffect.R;
import com.jastzeonic.snoweffect.view.item.AbstractItem;
import com.jastzeonic.snoweffect.view.item.SnowItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The View for present the movement of image that we put.
 * Created by jast.lai on 21/12/2017.
 */
public class EffectView extends View {


    private List<AbstractItem> items = new ArrayList<>();

    private Random random = new Random();
    Drawable snowDrawable;

    public EffectView(Context context) {
        super(context);
    }

    public EffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowDrawable = getResources().getDrawable(R.drawable.ic_snowflake_01);

        for (int i = 0; i < 30; i++) {
            items.add(new SnowItem());
        }

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);


        for (AbstractItem item : items) {
            item.setViewWidth(right);
            item.setViewHeight(bottom);
        }
        postDelayed(runnable, 10);

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int randomInteger = random.nextInt(2) + 3;
            int index = 0;

            for (AbstractItem item : items) {
                if (index >= randomInteger) {
                    break;
                }
                if (!item.isDisplay()) {
                    item.setDisplay(true);
                    index++;
                }
            }
            postDelayed(runnable, 3000);
        }
    };


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (AbstractItem item : items) {
            if (item.isDisplay()) {
                snowDrawable.setBounds(item.getPointX(), item.getPointY(), item.getPointX() + item.getSize(), item.getPointY() + item.getSize());
                snowDrawable.draw(canvas);
                item.fallDown();
                item.drift();
            }

        }

        postInvalidateDelayed(15);


    }
}

