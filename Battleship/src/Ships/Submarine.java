package Ships;

import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public class Submarine extends Ship {
    private ShipCoordinate coordinate;
    public Submarine(){
        this.length = 3;
        this.letter = 'S';
    }

    public ShipCoordinate getCoordinate(){
        return this.coordinate;
    }

    public String toString(){
        return "submarine";
    }
}