package Players;
import Coordinate.HumanBehavior;
import Coordinate.InputBehavior;
import Fleet.Fleet;
import java.util.ArrayList;

import Grids.OceanGrid;
import Ships.Ship;

import Coordinate.ShotCoordinate;


public class HumanPlayer extends Player{
    Fleet fleet;

    // Attribute isAlive?

    public HumanPlayer(){
        this.ib = new HumanBehavior();
        this.ShotsFired = new ArrayList<ShotCoordinate>();
        this.grid = new OceanGrid();
    }//initialize fleet, call fleet.placeFleet
    //public ShotCoordinate shoot(){}
    // returns object of type ShotCoordinate with coordinates in grid after adding it to ShotsFired

       // ShotCoordinate shot = new ShotCoordinate(this.ib);
     //   ShotsFired.add(shot);
    //    return shot;
   // }
    public void checkFleet(){};
}
