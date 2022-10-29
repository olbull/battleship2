package Grids;
import Coordinate.ShipCoordinate;
import java.util.ArrayList;

public class OceanGrid extends Grid{
    char[][] gridStructure = new char[10][10];
    private ArrayList<ShipCoordinate> ships; //oder besser als zweites, bereits platziertes Array?
    protected void printHeader(){
        System.out.println("--------------------------");
        System.out.println("====== OCEAN GRID ======");
        System.out.println();
    }
}

