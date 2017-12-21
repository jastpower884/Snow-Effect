package com.jastzeonic.snoweffect.view.item;


import java.util.Random;

/**
 * Created by jast.lai on 21/12/2017.
 */

public class SnowItem extends AbstractItem {

    private int radiusSize;
    private Random random = new Random();

    private int fallDistance = random.nextInt(3) + 3;
    private static final int driftDistance = 3;
    private int alreadyDriftDistance = 0;
    private int driftRange = 25;
    private int slowDownCount = 0;

    private boolean isDriftToRightSide = random.nextBoolean();

    public SnowItem() {

    }

    @Override
    public void setViewHeight(int viewHeight) {
        super.setViewHeight(viewHeight);
        radiusSize = (random.nextInt(70)) + 30;
        setCirclePointY(-radiusSize);


    }

    @Override
    public void setViewWidth(int viewWidth) {
        super.setViewWidth(viewWidth);
        randomSetPointX();
    }

    private void randomSetPointX() {
        setCirclePointX((random.nextInt(getViewWidth() - radiusSize)) <= 0 ? radiusSize + radiusSize :
                random.nextInt(getViewWidth() - radiusSize));
    }


    @Override
    public void fallDown() {

        int fallDownPoint = getCirclePointY() + fallDistance - slowDownCount;

        if (fallDownPoint > getViewHeight() + radiusSize) {
            fallDownPoint = -radiusSize;
            setDisplay(false);
            randomSetPointX();
        }
        setCirclePointY(fallDownPoint);

    }


    @Override
    public void drift() {

        int driftPoint;

        if (isDriftToRightSide) {
            if (alreadyDriftDistance > driftRange) {
                isDriftToRightSide = false;
                driftRange = random.nextInt(getViewWidth()) + 10;
                slowDownCount = fallDistance - 3;
            } else {
                int distance = random.nextInt(driftDistance);
                driftPoint = getCirclePointX() + distance;
                alreadyDriftDistance += distance;
                setCirclePointX(driftPoint);

                if (slowDownCount > 0) {
                    slowDownCount--;
                }
            }
        } else {
            if (alreadyDriftDistance < -driftRange) {

                isDriftToRightSide = true;
                driftRange = random.nextInt(getViewWidth()) + 10;
                slowDownCount = fallDistance - 3;
            } else {
                int distance = random.nextInt(driftDistance);
                driftPoint = getCirclePointX() - distance;
                alreadyDriftDistance -= distance;
                setCirclePointX(driftPoint);

                if (slowDownCount > 0) {
                    slowDownCount--;
                }
            }

        }


    }


    @Override
    public int getSize() {
        return radiusSize;
    }
}
