package Fleet;
import java.util.ArrayList;
import Coordinate.ShipCoordinate;
import Ships.*;
import java.util.*;
import java.lang.Iterable;

public class Fleet implements Iterable<Ships.Ship>{
    public final ArrayList<Ships.Ship> fleet = new ArrayList<>();
    boolean alive = true;
    public final int fleetSize = 10;

    public Fleet(){
        initializeFleet();
    }

    @Override
    public Iterator<Ship> iterator(){
        Iterator<Ship> iter = new Iterator(){
            private int currentIndex = 0;
            @Override
            public boolean hasNext(){
                return currentIndex < fleetSize; // Nr Ships in Fleet

            }
            @Override
            public Ship next(){
                if (hasNext()) return fleet.get(currentIndex++);
                else throw new UnsupportedOperationException("Not supported");
            }
        };
        return iter;
    }




    public void placeShips(){
        /*boolean[][] controlMatrix = new boolean[10][10];
        for(int i = 0; i < controlMatrix.length; i++){
            for(int j = 0; j < controlMatrix.length; j++){
                controlMatrix[i][j] = false;
            }
        }*/

        Iterator<Ship> iter = fleet.iterator();
        while (iter.hasNext()) {
            Ship s = iter.next();
            ShipCoordinate temp = s.placeShip();
        }
    }

    public void checkShips(){
        // Iterator<Ship> iterator = fleet.iterator();
    }

    public void initializeFleet(){
        fleet.add(new Carrier());
        fleet.add(new BattleShip());
        fleet.add(new BattleShip());
        fleet.add(new Submarine());
        fleet.add(new Submarine());
        fleet.add(new Submarine());
        fleet.add(new PatrolBoat());
        fleet.add(new PatrolBoat());
        fleet.add(new PatrolBoat());
        fleet.add(new PatrolBoat());

        //fleet[0] = new Carrier();
        //fleet[1] = new BattleShip();
        //fleet[2] = new BattleShip();
        //fleet[3] = new Submarine();
        //fleet[4] = new Submarine();
        //fleet[5] = new Submarine();
        //fleet[6] = new PatrolBoat();
        //fleet[7] = new PatrolBoat();
        //fleet[8] = new PatrolBoat();
        //fleet[9] = new PatrolBoat();
    }

}

