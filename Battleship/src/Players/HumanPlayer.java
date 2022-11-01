package Players;
import Coordinate.HumanBehavior;
import Fleet.Fleet;
import java.util.ArrayList;

import Grids.OceanGrid;
import Ships.Ship;


public class HumanPlayer extends Player{

    public HumanPlayer(){
        this.ib = new HumanBehavior();
        this.ShotsFired = new ArrayList<>();
        this.grid = new OceanGrid();
        this.fleet = new Fleet();
    }

    public OceanGrid placeFleet(){
        OceanGrid og = new OceanGrid();
        og.draw();
        for(Ship ship: fleet) {
            ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship, this.ib);
            while(!control){
                ship.placeShip(this.ib);
                control = fleet.placementControl(ship, this.ib);
            }
            og.addShip(ship.getCoordinate(), ship.letter);
            og.draw();
        }
        return og;
    }
}
