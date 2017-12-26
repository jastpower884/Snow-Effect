package com.jastzeonic.snoweffect.view.item;


import java.util.Random;

/**
 * This item is using by count and record the X Y point.
 * Created by jast.lai on 21/12/2017.
 */

public class SnowItem extends AbstractItem {

    private int radiusSize;
    private Random random = new Random();

    private int fallingLength = random.nextInt(3) + 1;

    /**
     * vibration amplitude 波幅
     */
    private final int amplitude = random.nextInt(10) + 20;

    /**
     * 波長 wavelength
     */
    private final int wavelength = random.nextInt(50 * fallingLength) + 50;
    private int startPointX = 0;

    public SnowItem() {
        super();
    }

    @Override
    public void setViewHeight(int viewHeight) {
        super.setViewHeight(viewHeight);
        radiusSize = (random.nextInt(20)) + 10;
        setPointY(-radiusSize);


    }

    @Override
    public void setViewWidth(int viewWidth) {
        super.setViewWidth(viewWidth);
        randomSetPointX();
        startPointX = getPointX();
    }

    private void randomSetPointX() {
        setPointX((random.nextInt(getViewWidth() - radiusSize)) <= 0 ? radiusSize + radiusSize :
                random.nextInt(getViewWidth() - radiusSize));
    }


    @Override
    public void fallDown() {

        int fallDownPoint = getPointY() + fallingLength;

        if (fallDownPoint > getViewHeight() + radiusSize) {
            fallDownPoint = -radiusSize;
            setDisplay(false);
            randomSetPointX();
        }
        setPointY(fallDownPoint);

    }


    @Override
    public void drift() {

        int driftPoint;
        double pointY = getPointY();
        // 象限角，這邊也作為角頻率
        double angularFrequency = pointY / wavelength;

        int movementDistance = (int) (amplitude * Math.sin(angularFrequency));
        driftPoint = startPointX + movementDistance;
        setPointX(driftPoint);

    }


    @Override
    public int getSize() {
        return radiusSize;
    }


}
