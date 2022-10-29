package Ships;
import Coordinate.*;

public abstract class Ship {
    public int length;
    public char letter;
    private int hits;

    public ShipCoordinate coordinate;

    public Ship() {
        this.hits = 0;
    }


    public ShipCoordinate placeShip(){return null;
    };

    public boolean isSunk() {
        return this.hits == this.length;
    }

    public boolean isHit(ShotCoordinate sc) {
        if (this.coordinate.x1 <= sc.x && sc.x <= this.coordinate.x2 && this.coordinate.y1 == sc.y) {
            this.hits += 1;
            return true;
        }
        if (this.coordinate.y1 <= sc.y && sc.y <= this.coordinate.y2 && this.coordinate.x1 == sc.x) {
            this.hits += 1;
            return true;
        }
        return false;
    }

    public ShipCoordinate getShipCoordinate() {
        return this.coordinate;
    }
}