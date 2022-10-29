package Ships;

import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;

public class BattleShip extends Ship {
    private ShipCoordinate coordinate;
    public BattleShip(){
        this.length = 4;
        this.letter = 'B';
    }

    public ShipCoordinate getCoordinate(){
        return this.coordinate;
    }
    public String toString(){
        return "battleship";
    }



}