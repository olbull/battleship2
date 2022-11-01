package Players;

import Coordinate.cpuBehavior;
import Fleet.Fleet;
import java.util.ArrayList;
import Grids.TargetGrid;
import Ships.Ship;


public class cpuPlayer extends Player {

    public cpuPlayer(){
        this.ib = new cpuBehavior();
        this.ShotsFired = new ArrayList<>();
        this.grid = new TargetGrid();
        this.fleet = new Fleet();
    }//initialize fleet, call fleet.placeFleet

    public TargetGrid placeFleet(){
        for(Ship ship: fleet) {
            ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship, this.ib);
            while(!control){
                ship.placeShip(this.ib);
                control = fleet.placementControl(ship, this.ib);
            }
        }
        return new TargetGrid();
    }
}

