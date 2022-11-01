package Fleet;
import java.util.ArrayList;

import Coordinate.HumanBehavior;
import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;
import Ships.*;
import java.util.*;
import java.lang.Iterable;


public class Fleet implements Iterable<Ships.Ship>{
    private final ArrayList<Ships.Ship> fleet = new ArrayList<>();
    private boolean alive = true;
    private final int fleetSize = 10;

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



    public boolean placementControl(Ship ship, InputBehavior ib) {
        //Iterator<Ship> iter = fleet.iterator();
        for (Ship shipPlaced : fleet) {
            if (shipPlaced.getCoordinate() != null && shipPlaced != ship) {
                if (((ship.getCoordinate().getX1() >= shipPlaced.getCoordinate().getX1() - 1 && ship.getCoordinate().getX1() <= shipPlaced.getCoordinate().getX2() + 1) || (ship.getCoordinate().getX2() >= shipPlaced.getCoordinate().getX1() - 1 && ship.getCoordinate().getX2() <= shipPlaced.getCoordinate().getX2() + 1))
                        && ((ship.getCoordinate().getY1() >= shipPlaced.getCoordinate().getY1() - 1 && ship.getCoordinate().getY1() <= shipPlaced.getCoordinate().getY2() + 1) || (ship.getCoordinate().getY2() >= shipPlaced.getCoordinate().getY1() - 1 && ship.getCoordinate().getY2() <= shipPlaced.getCoordinate().getY2() + 1))
                ) {
                    if(ib instanceof HumanBehavior) {
                        System.out.println("You cannot place ships next to each other!\nTry again...");
                    }
                    return false;
                }
            }
        }
        return true;
    }




    private void initializeFleet(){
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
