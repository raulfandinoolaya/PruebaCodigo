package controller;

import model.Car;
import model.Command;
import model.Surface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class CarController {
    private Surface surface;
    private Car car;

    public CarController(Car car, Surface surface) {
        this.car = car;
        this.surface = surface;
    }

    public void moveToNorth(int steps){
        if(car.getYPosition()+steps<surface.getNumberColumns()){
            car.setYPosition(car.getYPosition() + steps);
            showSuccessfulMessageAndNewPosition(car.getXPosition(), car.getYPosition());
        }else{
            showLimitsErrorMessage();
        }
    }

    public void moveToSouth(int steps){
        if(car.getYPosition()-steps>=0){
            car.setYPosition(car.getYPosition() - steps);
            showSuccessfulMessageAndNewPosition(car.getXPosition(), car.getYPosition());
        }else{
            showLimitsErrorMessage();
        }
    }

    public void moveToEast(int steps){
        if(car.getXPosition()+steps<surface.getNumberRows()){
            car.setXPosition(car.getXPosition() + steps);
            showSuccessfulMessageAndNewPosition(car.getXPosition(), car.getYPosition());
        }else{
            showLimitsErrorMessage();
        }
    }

    public void moveToWest(int steps){
        if(car.getXPosition()-steps>=0){
            car.setXPosition(car.getXPosition() - steps);
            showSuccessfulMessageAndNewPosition(car.getXPosition(), car.getYPosition());
        }else{
            showLimitsErrorMessage();
        }
    }

    public void moveAccordingToCommand(String commandsFU){
        ArrayList<Command> commands = extractCommands(commandsFU);
        for(Command command : commands){
            switch (command.getDirection().toCharArray()[0]){
                case 'N':moveToNorth(command.getNumberSteps());
                    break;
                case 'S':moveToSouth(command.getNumberSteps());
                    break;
                case 'E':moveToEast(command.getNumberSteps());
                    break;
                case 'O':moveToWest(command.getNumberSteps());
                    break;
                default:
                	showFormatErrorMessage();
            }
        }

    }

    private ArrayList<Command> extractCommands(String commandsFU) {
        List<String> commandsListReceived;
        ArrayList<Command> commandsListToExecute = new ArrayList<Command>();
        commandsListReceived = Arrays.asList(commandsFU.split(";"));
        for(String command : commandsListReceived){
            try{
                int steps = Integer.parseInt(command.split(",")[0].trim());
                String direction = command.split(",")[1].trim();
                if(command.split(",").length>2) throw new EmptyStackException() ;
                Command commandToExec = new Command(direction, steps);
                commandsListToExecute.add(commandToExec);
            }catch (Exception e){
            	showFormatErrorMessage();
            }
        }
        return commandsListToExecute;
    }

    private void showSuccessfulMessageAndNewPosition(int positionX, int positionY) {
        System.out.println("Movimiento realizado, nueva posición: ("+positionX+","+positionY+")");
    }

    private void showLimitsErrorMessage() {
        System.err.println("Se ha detenido el avance por exceder los límites.");
    }
    
    private void showFormatErrorMessage() {
        System.err.println("Error en formato de comando.");
    }
}
