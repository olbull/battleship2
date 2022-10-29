package Ships;

import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public class Carrier extends Ship {
    private ShipCoordinate coordinate;
    public Carrier(){
        this.length = 6;
        this.letter = 'C';
    }

    public ShipCoordinate getCoordinate(){
        return this.coordinate;
    }

    public String toString(){
        return "carrier";
    }
}