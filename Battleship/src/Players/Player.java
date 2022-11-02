package Players;
import Coordinate.*;
import Ships.*;
import ShotResults.*;
import Fleet.Fleet;
import ShotResults.ShotStates;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Player {
    Fleet fleet;
    protected ArrayList<ShotCoordinate> ShotsFired;
    protected InputBehavior ib;

    public ShotCoordinate shoot() { // returns object of type ShotCoordinate with coordinates in grid after adding it to ShotsFired
        ShotCoordinate shot = new ShotCoordinate(ib);
        for (ShotCoordinate s : ShotsFired) {
            if (shot.equals(s)) {
                if (this instanceof HumanPlayer){
                System.out.println("You have already shot at this target!\nChoose another one...\n");} //olbu
                return shoot();
            }
        }
        ShotsFired.add(shot);
        return shot;
    }

    private HashMap<Integer, Character> getTranslator(){
        HashMap<Integer, Character> translation = new HashMap<>();
        translation.put(0, 'A');
        translation.put(1, 'B');
        translation.put(2, 'C');
        translation.put(3, 'D');
        translation.put(4, 'E');
        translation.put(5, 'F');
        translation.put(6, 'G');
        translation.put(7, 'H');
        translation.put(8, 'I');
        translation.put(9, 'J');

        return translation;
    }

    public SunkResult isSunk(ShotCoordinate sc) {// sc is in grid and was not already shot i.e. valid
        //String transcord = getTranslator().get(sc.x) + Integer.toString(sc.y);
        ShotStates state = ShotStates.MISS;
        for (Ship ship : this.fleet) {
            if (ship.isHit(sc)) {
                state = ShotStates.HIT;
                //if (this instanceof cpuPlayer){System.out.println("You were hit at position " + transcord);}
                //else {System.out.println("You hit CPU at position " + transcord);}

                if (ship.isSunk()) {
                    if (ship instanceof PatrolBoat) {
                        state = ShotStates.SUNKPB;
                    }
                    if (ship instanceof Submarine) {
                        state = ShotStates.SUNKSM;
                    }
                    if (ship instanceof BattleShip) {
                        state = ShotStates.SUNKBS;
                    }
                    if (ship instanceof Carrier) {
                        state = ShotStates.SUNKC;
                    }
                    ShipCoordinate shipco = ship.getCoordinate();
                    return new SunkResult(state, shipco);
                }
            }
        }

        return new SunkResult(state, null);
    }

    public boolean isAlive(){
        for (Ship ship : this.fleet){
            if(! ship.isSunk()){
                return true;
            }
        }
        return false;
    }

    public void declareShot(ShotStates state, ShotCoordinate sc){
        String transcord = getTranslator().get(sc.x) + Integer.toString(sc.y);
        if (state == ShotStates.HIT){
            if (this instanceof cpuPlayer){
                System.out.println("You were hit at position " + transcord + "!\n");}
            else {System.out.println("You hit CPU at position " + transcord+"!\n");}
        }
        else {
            if (this instanceof HumanPlayer) {
                System.out.println("You missed at position " + transcord+".\n");
            } else {
                System.out.println("CPU missed your fleet at position " + transcord+".\n");
            }
        }
    }
}

