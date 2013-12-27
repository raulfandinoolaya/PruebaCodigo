package test;

import controller.CarController;
import junit.framework.Assert;
import model.Car;
import model.Surface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class VehicleTest {
    public final int NUMBER_ROWS_TEST = 6;
    public final int NUMBER_COLUMNS_TEST = 8;

    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    Surface surface = new Surface(NUMBER_ROWS_TEST, NUMBER_COLUMNS_TEST);

    @Test
    public void testOneStepToNorth(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        carController.moveToNorth(1);
        Assert.assertTrue(car.getYPosition()==1);
    }

    @Test
    public void testNumberInvalidStepsToNorth(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        carController.moveToNorth(NUMBER_COLUMNS_TEST+1);
        Assert.assertTrue(car.getYPosition()==0);
        Assert.assertTrue(car.getXPosition()==0);
    }

    @Test
    public void testOneStepToSouth(){
        Car car = new Car(NUMBER_ROWS_TEST,NUMBER_COLUMNS_TEST);
        CarController carController = new CarController(car, surface);
        carController.moveToSouth(1);
        Assert.assertTrue(car.getYPosition()==NUMBER_COLUMNS_TEST-1);
        Assert.assertTrue(car.getXPosition()==NUMBER_ROWS_TEST);
    }

    @Test
    public void testNumberInvalidStepsToSouth(){
        Car car = new Car(NUMBER_ROWS_TEST,NUMBER_COLUMNS_TEST);
        CarController carController = new CarController(car, surface);
        carController.moveToSouth(NUMBER_COLUMNS_TEST + 1);
        Assert.assertTrue(car.getYPosition()==NUMBER_COLUMNS_TEST);
        Assert.assertTrue(car.getXPosition()==NUMBER_ROWS_TEST);
    }

    @Test
    public void testOneStepToEast(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        carController.moveToEast(1);
        Assert.assertTrue(car.getXPosition()==1);
        Assert.assertTrue(car.getYPosition()==0);
    }

    @Test
    public void testNumberInvalidStepsToEast(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        carController.moveToEast(NUMBER_ROWS_TEST + 1);
        Assert.assertTrue(car.getXPosition()==0);
        Assert.assertTrue(car.getYPosition()==0);
    }

    @Test
    public void testOneStepToWest(){
        Car car = new Car(NUMBER_ROWS_TEST,NUMBER_COLUMNS_TEST);
        CarController carController = new CarController(car, surface);
        carController.moveToWest(1);
        Assert.assertTrue(car.getXPosition()==NUMBER_ROWS_TEST-1);
        Assert.assertTrue(car.getYPosition()==NUMBER_COLUMNS_TEST);
    }

    @Test
    public void testNumberInvalidStepsToWest(){
        Car car = new Car(NUMBER_ROWS_TEST,NUMBER_COLUMNS_TEST);
        CarController carController = new CarController(car, surface);
        carController.moveToWest(NUMBER_ROWS_TEST + 1);
        Assert.assertTrue(car.getXPosition()==NUMBER_ROWS_TEST);
        Assert.assertTrue(car.getYPosition()==NUMBER_COLUMNS_TEST);
    }

    @Test
    public void testMoveAccordingOneCommand(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        String command = "2,N";
        carController.moveAccordingToCommand(command);
        Assert.assertTrue(car.getYPosition()==2);
        Assert.assertTrue(car.getXPosition()==0);
    }

    @Test
    public void testMoveAccordingFourCommand(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        String command = "2,N;3,E;5,N;1,O";
        carController.moveAccordingToCommand(command);
        Assert.assertTrue(car.getXPosition()==2);
        Assert.assertTrue(car.getYPosition()==7);
        Assert.assertEquals("Movimiento realizado, nueva posición: (0,2)\r\n" +
                "Movimiento realizado, nueva posición: (3,2)\r\n" +
                "Movimiento realizado, nueva posición: (3,7)\r\n" +
                "Movimiento realizado, nueva posición: (2,7)\r\n",outContent.toString());
    }

    @Test
    public void testDoNotMoveWithBadCommand(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        String command = "   2aaaa   ,   N   ";
        carController.moveAccordingToCommand(command);
        Assert.assertTrue(car.getXPosition()==0);
        Assert.assertTrue(car.getYPosition()==0);
        Assert.assertEquals("Error en formato de comando.\r\n", errContent.toString());
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
