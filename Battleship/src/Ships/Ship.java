package Ships;
import Coordinate.*;

public abstract class Ship {
    public int length;
    public char letter;
    private int hits;

    private ShipCoordinate coordinate;

    public Ship() {
        this.hits = 0;
    }


    public void placeShip(InputBehavior ib){
        if (ib instanceof HumanBehavior) {
            System.out.println("Place your " + this.getClass().getSimpleName() + " of length " + this.length +".");
            ShipCoordinate tempCord = new ShipCoordinate(ib);
            while (tempCord.x2 - tempCord.x1 != this.length - 1 && tempCord.y2 - tempCord.y1 != this.length - 1) {
                System.out.println("Your range must cover the length (" + this.length +
                        ") of your " + this.getClass().getSimpleName() + "!\nTry again...");
                tempCord = new ShipCoordinate(ib);
            }
            this.coordinate = tempCord;

        }
        else{
            ShipCoordinate tempCord = new ShipCoordinate(ib);
            while (tempCord.x2 - tempCord.x1 != this.length - 1 && tempCord.y2 - tempCord.y1 != this.length - 1) {
                tempCord = new ShipCoordinate(ib);
            }
            this.coordinate = tempCord;

        }

    }

    public boolean isSunk() {
        return this.hits == this.length;
    }

    public boolean isHit(ShotCoordinate sc) {
        if (this.coordinate.x1 <= sc.x && sc.y <= this.coordinate.x2 && this.coordinate.y1 == sc.y) {
            this.hits += 1;
            return true;
        }
        if (this.coordinate.y1 <= sc.y && sc.y <= this.coordinate.y2 && this.coordinate.x1 == sc.x) {
            this.hits += 1;
            return true;
        }
        return false;
    }

    public ShipCoordinate getCoordinate() {
        return this.coordinate;
    }
}