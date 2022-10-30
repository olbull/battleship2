package Players;
import Coordinate.InputBehavior;
import Coordinate.cpuBehavior;
import Fleet.Fleet;
import java.util.ArrayList;
import Coordinate.ShotCoordinate;
import Grids.TargetGrid;


public class cpuPlayer extends Player {
    Fleet fleet;
    // Attribute isAlive?

    public cpuPlayer(){
        this.ib = new cpuBehavior();
        this.ShotsFired = new ArrayList<ShotCoordinate>();
        this.grid = new TargetGrid();
    }//initialize fleet, call fleet.placeFleet
    public void handleShot(){}
    public void checkFleet(){}
}
