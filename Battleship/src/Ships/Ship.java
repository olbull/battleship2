package Ships;
import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public abstract class Ship {
    public int length;
    public char letter;
    boolean state; //implement state pattern!
    private ShipCoordinate coordinate;

    public ShipCoordinate placeShip(InputBehavior ib){
        System.out.println("Place your " + this.toString() + " of length " + this.length);
        ShipCoordinate tempCord = new ShipCoordinate(ib);
        while (tempCord.x2 - tempCord.x1 != this.length - 1 && tempCord.y2 - tempCord.y1 != this.length -1){
            System.out.println("Your range must cover the length ("+ this.length +
                    ") of your " + this.toString() + "!\nTry again...");
            tempCord = new ShipCoordinate(ib);
        }
        this.coordinate = tempCord;
        return tempCord;
    }


    public ShipCoordinate getCoordinate(){
        return this.coordinate;
    };
}