package Players;
import Coordinate.*;
import Fleet.Fleet;
import java.util.ArrayList;
import Grids.OceanGrid;
import Ships.Ship;

public class HumanPlayer extends Player{

    public HumanPlayer(){
        this.ib = new HumanBehavior();
        this.ShotsFired = new ArrayList<>();
        this.fleet = new Fleet();
    }

    public OceanGrid placeFleet(){
        System.out.println("This is your grid. ");
        OceanGrid og = new OceanGrid();
        og.draw();
        System.out.println("We'll begin by placing your fleet. Note that ships can be placed next to each other...\n");
        for(Ship ship: fleet) {
            ship.placeShip(this.ib);
            boolean control = fleet.placementControl(ship, this.ib); //olbu

            while(!control){
                ship.placeShip(this.ib);
                control = fleet.placementControl(ship, this.ib); //olbu
            }
            og.addShip(ship.getCoordinate(), ship.getLetter());
            og.draw();

        }
        System.out.println("Alright, your fleet is ready for combat.");
        return og;
    }
}
