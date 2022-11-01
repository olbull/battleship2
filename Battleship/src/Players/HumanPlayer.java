package Players;
import Coordinate.HumanBehavior;
import Coordinate.InputBehavior;
import Coordinate.ShipCoordinate;
import Fleet.Fleet;
import java.util.ArrayList;

import Grids.OceanGrid;
import Grids.TargetGrid;
import Ships.Ship;

import Coordinate.ShotCoordinate;


public class HumanPlayer extends Player{

    // Attribute isAlive?

    public HumanPlayer(){
        this.ib = new HumanBehavior();
        this.ShotsFired = new ArrayList<ShotCoordinate>();
        this.grid = new OceanGrid();
        this.fleet = new Fleet();
    }

    public OceanGrid placeFleet(){
        OceanGrid og = new OceanGrid();
        TargetGrid tg = new TargetGrid();
        tg.draw(); og.draw();
        for(Ship ship: fleet) {
            ShipCoordinate temp = ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship, this.ib);
            while(!control){
                temp = ship.placeShip(this.ib);
                control = fleet.placementControl(ship, this.ib);
            }
            og.addShip(ship.getCoordinate(), ship.letter);
            og.draw();
        }
        return og;
    }
}
