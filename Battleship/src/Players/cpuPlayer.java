package Players;
import Coordinate.*;
import Fleet.Fleet;
import java.util.ArrayList;
import Grids.TargetGrid;
import Ships.Ship;


public class cpuPlayer extends Player {
    public cpuPlayer(){
        this.ib = new cpuBehavior();
        this.ShotsFired = new ArrayList<>();
        this.fleet = new Fleet();
    }

    public TargetGrid placeFleet(){
        TargetGrid tg = new TargetGrid();
        System.out.println("This is your opponent's grid.");
        tg.draw();
        for(Ship ship: fleet) {
            ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship, this.ib); //olbu
            while(!control){
                ship.placeShip(this.ib);
                control = fleet.placementControl(ship, this.ib); //olbu
            }
        }
        return tg;
    }
}
