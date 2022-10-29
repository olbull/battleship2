package Ships;

import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public class PatrolBoat extends Ship {
    private ShipCoordinate coordinate;
    public PatrolBoat(){
        this.length = 2;
        this.letter = 'P';
    }
    public ShipCoordinate getCoordinate(){
        return this.coordinate;
    }

    public String toString(){
        return "patrol boat";
    }
}