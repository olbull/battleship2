
import Coordinate.*;
import Fleet.*;
import Grids.*;
import Ships.*;
import Coordinate.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {



        Fleet a = new Fleet();
        HumanBehavior hb = new HumanBehavior();
        a.placeShips(hb);
        //Coordinate.ShipCoordinate myFirst = new Coordinate.ShipCoordinate(new Coordinate.HumanBehavior());
        //System.out.print(myFirst.x1 + " " + myFirst.y1 + "\n");
        //System.out.print(myFirst.x2 + " " + myFirst.y2 + "\n");

        //ShotCoordinate mySecond = new ShotCoordinate(new cpuBehavior());
        //System.out.print(mySecond.x + " " + mySecond.y);
        //HumanPlayer p1 = new HumanPlayer();
        //ShotCoordinate shot1 = p1.shoot();
        // ShotCoordinate shot2 = p1.shoot();

       //TargetGrid firstOne = new TargetGrid();
        //OceanGrid secondOne = new OceanGrid();
        //firstOne.draw();
        //secondOne.draw();
        //firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 's');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'p');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'l');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'e');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'e');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'n');
        // firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'e');
       /* for (int i = 0; i < 6; i++) {
            firstOne.draw();
            secondOne.draw();
            firstOne.editArrayShot(new ShotCoordinate(new HumanBehavior()), 'o');
            secondOne.editArrayShot(new ShotCoordinate(new cpuBehavior()), 'x');
        }
        firstOne.draw();
        secondOne.draw();
*/
    }
}