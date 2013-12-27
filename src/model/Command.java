package model;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class Command {
    private String direction;
    private int numberSteps;

    public Command(String direction, int numberSteps) {
        this.direction = direction;
        this.numberSteps = numberSteps;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getNumberSteps() {
        return numberSteps;
    }

    public void setNumberSteps(int numberSteps) {
        this.numberSteps = numberSteps;
    }
}
