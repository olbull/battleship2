package Coordinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
// add design elements
public class HumanBehavior implements InputBehavior {
    HashMap<Character, Integer> reference = new HashMap<Character, Integer>();

    public HumanBehavior() {
        reference.put('A', 0); //HashMap wird hier gefüllt, da Coordinates.Coordinate.cpuBehavior diese nicht braucht(!) (und wir keine bessere Lösung haben...)
        reference.put('B', 1);
        reference.put('C', 2);
        reference.put('D', 3);
        reference.put('E', 4);
        reference.put('F', 5);
        reference.put('G', 6);
        reference.put('H', 7);
        reference.put('I', 8);
        reference.put('J', 9);
        reference.put('0', 0);
        reference.put('1', 1);
        reference.put('2', 2);
        reference.put('3', 3);
        reference.put('4', 4);
        reference.put('5', 5);
        reference.put('6', 6);
        reference.put('7', 7);
        reference.put('8', 8);
        reference.put('9', 9);
    }
@Override
    public ArrayList<Integer> generateShipCoordinate(){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter coordinates, separated by comma.\nExample: A4,B4");
        String stringInput = InputScanner.nextLine();
        char[] arrayInput = stringInput.toCharArray();

        if(arrayInput.length != 5){
            System.out.println("Invalid input format! Try again...\n");
            return generateShipCoordinate();
        }

        if (arrayInput[2] != ','){
            System.out.println("Invalid input format! Try again...\n");
            return generateShipCoordinate();
        }


        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                if (reference.containsKey(arrayInput[i])) {
                    output.add(reference.get(arrayInput[i]));
                } else {
                    System.out.println("X-coordinate must be in range A-J and y-coordinate must be in range 0-9!\nTry again...\n");
                    return generateShipCoordinate();
                }
            }
        }
        if (output.get(0) == output.get(2) && output.get(1) == output.get(3)) {
            System.out.println("Ship can not be placed in a single cell!\nTry again...\n");
            return generateShipCoordinate();
        }
        if (output.get(0) != output.get(2) && output.get(1) != output.get(3)) {
            System.out.println("Ships need to be placed either horizontally or vertically!\nTry again...\n");
            return generateShipCoordinate();
        }

        // hier gilt für das Array entweder array[0] = array[2] (horizontal) oder array[1] = array[3] (vertikal)
        if (output.get(0) == output.get(2) && output.get(1) > output.get(3)) {
            Collections.swap(output,1,3);
        }
        if (output.get(1) == output.get(3) && output.get(0) > output.get(2)) {
            Collections.swap(output,0,2);
        }
        return output;
    }
    @Override
    public ArrayList<Integer> generateShotCoordinate(){
        ArrayList<Integer> output = new ArrayList<Integer>();
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter Coordinates:\nExample: A7");
        String stringInput = InputScanner.nextLine();
        char[] arrayInput = stringInput.toCharArray();

        if (arrayInput.length != 2){
            System.out.println("Invalid Input Format! Try again...\n");
            return generateShotCoordinate();
        }

        if (reference.containsKey(arrayInput[0]) && reference.containsKey(arrayInput[1])){
            output.add(reference.get(arrayInput[0]));
            output.add(reference.get(arrayInput[1]));
            }
        else{System.out.println("Invalid Input! Try again...\n");
        return generateShotCoordinate();}
        return output;
        }
}
