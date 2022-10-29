package Ships;
import Coordinate.ShipCoordinate;

public abstract class Ship {
    int length;
    char letter;
    int hits;
    BoatState state; //implement state pattern!
    ShipCoordinate coordinates;

    void placeShip(ShipCoordinate sc) {
        this.coordinates = sc;
    }

    void hit() {
    }
}
