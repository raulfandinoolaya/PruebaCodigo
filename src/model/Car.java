package model;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class Car {
    private int xPosition;
    private int yPosition;

    public Car(int xPosition, int yPosition) {
        this.setXPosition(xPosition);
        this.setYPosition(yPosition);
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
