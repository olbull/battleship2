package Players;
import Coordinate.*;
import Ships.*;

import Fleet.Fleet;
import ShotResults.HitResult;
import ShotResults.ShotStates;

import java.util.ArrayList;

public abstract class Player {
    Fleet fleet;
    protected ArrayList<ShotCoordinate> ShotsFired;
    // Attribute isAlive?
    protected InputBehavior ib;


    public ShotCoordinate shoot() { // returns object of type ShotCoordinate with coordinates in grid after adding it to ShotsFired
        ShotCoordinate shot = new ShotCoordinate(ib);
        for (ShotCoordinate s : ShotsFired) {
            if (shot.equals(s)) {
                System.out.println("You have already shot at this target!\nChoose another one...\n");
                return shoot();
            }
        }
        ShotsFired.add(shot);
        return shot;
    }



    public HitResult handleHit(ShotCoordinate sc) {// sc is in grid and was not already shot i.e. valid
        ShotStates state = ShotStates.MISS;

        for (Ship ship : this.fleet) {
            if (ship.isSunk()) {
                if (this.fleet.checkShips()) {state = ShotStates.SUNKFLEET;}
                if (ship instanceof PatrolBoat) {state = ShotStates.SUNKPB;}
                if (ship instanceof Submarine) {state = ShotStates.SUNKSM;}
                if (ship instanceof BattleShip) {state = ShotStates.SUNKBS;}
                if (ship instanceof Carrier) {state = ShotStates.SUNKC;}
                ShipCoordinate shipco = ship.getShipCoordinate();}

            }
        return new HitResult(state, shipco);
    }
}
