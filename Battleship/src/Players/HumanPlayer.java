package Players;
import Coordinate.HumanBehavior;
import Coordinate.InputBehavior;
import Fleet.Fleet;
import java.util.ArrayList;
import Ships.Ship;

import Coordinate.ShotCoordinate;


public class HumanPlayer extends Player{
    Fleet fleet;

    // Attribute isAlive?

    public HumanPlayer(){
        this.ib = new HumanBehavior();
        this.ShotsFired = new ArrayList<ShotCoordinate>();
    }//initialize fleet, call fleet.placeFleet
    //public ShotCoordinate shoot(){}
    // returns object of type ShotCoordinate with coordinates in grid after adding it to ShotsFired

       // ShotCoordinate shot = new ShotCoordinate(this.ib);
     //   ShotsFired.add(shot);
    //    return shot;
   // }

    public void handleShot(){}
    public void checkFleet(){};
}
