package Players;
import Coordinate.InputBehavior;
import Coordinate.ShotCoordinate;
import Fleet.Fleet;
import java.util.ArrayList;

public abstract class Player {
    Fleet fleet;
    protected ArrayList<ShotCoordinate> ShotsFired;
    // Attribute isAlive?
    protected InputBehavior ib;


    public ShotCoordinate shoot(){ // returns object of type ShotCoordinate with coordinates in grid after adding it to ShotsFired
        ShotCoordinate shot = new ShotCoordinate(ib);
        for (ShotCoordinate s : ShotsFired){
            if (shot.equals(s)){
                System.out.println("You have already shot at this target!\nChoose another one...\n");
                return shoot();
            }
        }
        ShotsFired.add(shot);
        return shot;
    }

    public abstract void handleShot();
}
