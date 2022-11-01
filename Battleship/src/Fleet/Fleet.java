package Fleet;
import java.util.ArrayList;

import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;
import Ships.*;
import java.util.*;
import java.lang.Iterable;


public class Fleet implements Iterable<Ships.Ship>{
    public final ArrayList<Ships.Ship> fleet = new ArrayList<>();
    boolean alive = true;
    public final int fleetSize = 10;

    public Fleet() {
        initializeFleet();
    }

    @Override
    public Iterator<Ship> iterator() {
        Iterator<Ship> iter = new Iterator() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < fleetSize; // Nr Ships in Fleet
            }

            @Override
            public Ship next() {
                if (hasNext()) return fleet.get(currentIndex++);
                else throw new UnsupportedOperationException("Not supported");
            }
        };
        return iter;
    }

    public boolean placementControl(Ship ship) {
        //Iterator<Ship> iter = fleet.iterator();
        for (Ship shipPlaced : fleet) {
            if (shipPlaced.getCoordinate() != null && shipPlaced != ship) {
                if (((ship.getCoordinate().x1 >= shipPlaced.getCoordinate().x1 - 1 && ship.getCoordinate().x1 <= shipPlaced.getCoordinate().x2 + 1) || (ship.getCoordinate().x2 >= shipPlaced.getCoordinate().x1 - 1 && ship.getCoordinate().x2 <= shipPlaced.getCoordinate().x2 + 1))
                        && ((ship.getCoordinate().y1 >= shipPlaced.getCoordinate().y1 - 1 && ship.getCoordinate().y1 <= shipPlaced.getCoordinate().y2 + 1) || (ship.getCoordinate().y2 >= shipPlaced.getCoordinate().y1 - 1 && ship.getCoordinate().y2 <= shipPlaced.getCoordinate().y2 + 1))
                ) {
                    System.out.println("You cannot place ships next to each other!\nTry again...\n");
                    return false;
                }
            }
        }
        return true;
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
    }

}
