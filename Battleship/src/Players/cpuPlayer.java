package Players;
import Coordinate.ShipCoordinate;
import Coordinate.cpuBehavior;
import Fleet.Fleet;
import java.util.ArrayList;
import Coordinate.ShotCoordinate;
import Grids.TargetGrid;
import Ships.Ship;


public class cpuPlayer extends Player {
    // Attribute isAlive?

    public cpuPlayer(){
        this.ib = new cpuBehavior();
        this.ShotsFired = new ArrayList<ShotCoordinate>();
        this.grid = new TargetGrid();
        this.fleet = new Fleet();
    }//initialize fleet, call fleet.placeFleet

    public TargetGrid placeFleet(){
        for(Ship ship: fleet) {
            ShipCoordinate temp = ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship);
            while(!control){
                temp = ship.placeShip(this.ib);
                control = fleet.placementControl(ship);
            }
        }
        return new TargetGrid();
    }
}

