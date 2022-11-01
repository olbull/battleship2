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
            while (tempCord.getX2() - tempCord.getX1() != this.length - 1 && tempCord.getY2() - tempCord.getY1() != this.length - 1) {
                System.out.println("Your range must cover the length (" + this.length +
                        ") of your " + this.getClass().getSimpleName() + "!\nTry again...");
                tempCord = new ShipCoordinate(ib);
            }
            this.coordinate = tempCord;
        }
        else{
            ShipCoordinate tempCord = new ShipCoordinate(ib);
            while (tempCord.getX2() - tempCord.getX1() != this.length - 1 && tempCord.getY2() - tempCord.getY1() != this.length - 1) {
                tempCord = new ShipCoordinate(ib);
            }
            this.coordinate = tempCord;
        }
    }
    public void placeShip1(InputBehavior ib){
        System.out.println("Place your " + this.toString() + " of length " + this.length);
        ShipCoordinate tempCord = new ShipCoordinate(ib);
        while (tempCord.getX2() - tempCord.getX1() != this.length - 1 && tempCord.getY2() - tempCord.getY1() != this.length -1){
            System.out.println("Your range must cover the length ("+ this.length +
                    ") of your " + this.toString() + "!\nTry again...");
            tempCord = new ShipCoordinate(ib);
        }
        this.coordinate = tempCord;
    }

    public boolean isSunk() {
        return this.hits == this.length;
    }

    public boolean isHit(ShotCoordinate sc) {
        if (this.coordinate.getX1() <= sc.getX() && sc.getX() <= this.coordinate.getX2() && this.coordinate.getY1() == sc.getY()) {
            this.hits += 1;
            return true;
        }
        if (this.coordinate.getY1() <= sc.getY() && sc.getY() <= this.coordinate.getY2() && this.coordinate.getX1() == sc.getX()) {
            this.hits += 1;
            return true;
        }
        return false;
    }

    public ShipCoordinate getCoordinate() {
        return this.coordinate;
    }
}