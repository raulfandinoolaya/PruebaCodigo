package view;

import controller.CarController;
import model.Car;
import model.Surface;

import java.util.Scanner;

/**
 * Created by FAMILIA on 25/12/13.
 */
public class Application {
    public  static void main(String[]args)throws Exception{
        boolean dimensionsVerified = false;
        boolean exit = false;
        int numberRows=0;
        int numberColumns=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Para empezar por favor ingrese las dimensiones de la superficie:");
        System.out.println("(Valores enteros y positivos)\n");

        while(!dimensionsVerified){
            System.out.println("Número de filas: ");
            numberRows = verifyInputs(scanner.nextLine());
            if (numberRows != -1){
                System.out.println("Número de columnas: ");
                numberColumns = verifyInputs(scanner.nextLine());
                Thread.sleep(200);
                if (numberColumns != -1){
                        dimensionsVerified=true;
                        }else{
                        dimensionsVerified=false;
                    }
            }else{
                dimensionsVerified=false;
            }
        }

        Surface surface = new Surface(numberRows, numberColumns);
        Car car = new Car(0,0);
        CarController carController = new CarController(car, surface);

        paintSurface(surface, car);

        while(!exit){
            System.out.println("Ingrese el comando o comandos de movimiento (Si desea salir digite únicamente '0'):");
            String commands = scanner.nextLine();
            carController.moveAccordingToCommand(commands);
            Thread.sleep(200);
            paintSurface(surface, car);
        }
        
        scanner.close();
    }

    private static int verifyInputs(String input) {
        int verifiedValue = -1;
        try{
            verifiedValue=Integer.parseInt(input);
            if(verifiedValue<=0){
                verifiedValue=-1;
                System.err.println("\nPor favor digite un número entero y mayor que cero.\n");
            }
        }catch (NumberFormatException e){
            System.err.println("\nPor favor digite un valor válido.\n");
        }
        return verifiedValue;
    }

    private static void paintSurface(Surface surface, Car car) {
        System.out.println("\nÁrea de desplazamiento: \n");
        for(int j = surface.getNumberColumns()-1; j>=0;j--){
            for (int i = 0; i<surface.getNumberRows(); i++){
                if(i==car.getXPosition()&&j==car.getYPosition()){
                    System.out.print("^.^ ");
                }else{
                    System.out.print("--- ");
                }
            }
            System.out.println();
        }
        System.out.println("\nUbicación actual: ("+car.getXPosition()+","+car.getYPosition()+").\n");
    }

}
