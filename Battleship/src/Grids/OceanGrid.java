package Grids;
import Coordinate.ShipCoordinate;
import java.util.ArrayList;

public class OceanGrid extends Grid{

    public OceanGrid() {
        super();
        char[][] gridStructure = new char[10][10];
    }

    protected void printHeader(){
        System.out.println("--------------------------");
        System.out.println("====== OCEAN GRID ======");
        System.out.println();
    }
}

