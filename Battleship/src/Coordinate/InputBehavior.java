package Coordinate;

import java.util.*;

public interface InputBehavior {
   HashMap<Character, Integer> reference = new HashMap<>();

    ArrayList<Integer> generateShipCoordinate();
    ArrayList<Integer> generateShotCoordinate();

}


