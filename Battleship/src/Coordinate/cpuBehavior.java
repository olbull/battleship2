package Coordinate;
import java.util.Collection;
import java.util.Random;
import java.util.Collections;

import java.util.ArrayList;

public class cpuBehavior implements InputBehavior {
    @Override
    public ArrayList<Integer> generateShipCoordinate() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            output.add(generateRandom(10));
        }
        int decider = generateRandom(2);
        if (decider == 0){
            output.add(output.get(0));
            output.add(generateRandom(10));
        }
        else {
            output.add(generateRandom(10));
            output.add(output.get(1));
        }
        if (output.get(0) == output.get(2) && output.get(1) == output.get(3)){
            return generateShipCoordinate();
        } // hier gilt für das Array entweder array[0] = array[2] (horizontal) oder array[1] = array[3] (vertikal)

        if (output.get(0) == output.get(2) && output.get(1) > output.get(3)) {
            Collections.swap(output,1,3);
        }
        if (output.get(1) == output.get(3) && output.get(0) > output.get(2)) {
            Collections.swap(output,0,2);
        }

        return output;
    }

    @Override
    public ArrayList<Integer> generateShotCoordinate() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            output.add(generateRandom(10));
        }
        return output;
    }

    private int generateRandom(int bound){
        Random rand = new Random();
       return rand.nextInt(bound);
    }
}
