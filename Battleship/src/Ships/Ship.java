package Ships;
import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public abstract class Ship {
    public int length;
    public char letter;
    boolean state; //implement state pattern!
    ShipCoordinate coordinate;


    public ShipCoordinate placeShip(){
        return null;
    };
}