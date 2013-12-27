package test;

import controller.CarController;
import junit.framework.Assert;
import model.Car;
import model.Surface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by FAMILIA on 25/12/13.
 */
@RunWith(Parameterized.class)
public class VehicleParameterizedTest{
    String badCommand;
    public final int NUMBER_ROWS_TEST = 6;
    public final int NUMBER_COLUMNS_TEST = 8;

    public final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    Surface surface = new Surface(NUMBER_ROWS_TEST, NUMBER_COLUMNS_TEST);
    public VehicleParameterizedTest(String badCommand) {
        this.badCommand = badCommand;
    }

    @Parameterized.Parameters
    public static Collection commandsWithInvalidNumberOfSteps() {
        return Arrays.asList(new Object[][]{
                {",,,,,,"},
                {"sads"},
                {"????????"},
                {"*%&·.///\\ºª"},
                {"!\"·$ERTGQ"},
                {"*"},
                {"1.2"},
                {".5"},
                {"\\n"},
                {"1000E2"}

        });
    }

    @Test
    public void testDoNotMoveWithAChainNotNumeric(){
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);
        String command = badCommand+",N";
        carController.moveAccordingToCommand(command);
        Assert.assertTrue(car.getXPosition() == 0);
        Assert.assertTrue(car.getYPosition()==0);
        Assert.assertEquals("La entrada es errada, verifique el formato y vuelva a intentarlo por favor.\r\n", errContent.toString());
    }

    @Before
    public void setUpStreams() {
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setErr(null);
    }
    
}
