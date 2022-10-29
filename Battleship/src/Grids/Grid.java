package Grids;
import Coordinate.ShipCoordinate;
import Coordinate.ShotCoordinate;
import ShotResults.ShotStates;

import java.util.HashMap;

public abstract class Grid {
    char[][] gridStructure = new char[10][10];
    HashMap<ShotStates, java.lang.Character> gridSymbols = new HashMap<ShotStates, Character>();


    //private ArrayList<ShipCoordinate> ships; //oder besser als zweites, bereits platziertes Array?

    public Grid(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                this.gridStructure[i][j] = ' ';
            }
        }
        gridSymbols.put(ShotStates.HIT, 'x');
        gridSymbols.put(ShotStates.MISS,'o');
        gridSymbols.put(ShotStates.SUNKPB, 'P');
        gridSymbols.put(ShotStates.SUNKSM, 'S');
        gridSymbols.put(ShotStates.SUNKC, 'C');
        gridSymbols.put(ShotStates.SUNKBS, 'B');
    }
    public void draw(){
        printHeader();
        System.out.println("   A B C D E F G H I J   ");
        System.out.println("  ---------------------   ");
        printBody();
        System.out.println("  ---------------------   ");
        System.out.println("   A B C D E F G H I J   ");
        System.out.println();
    }

    void printBody(){
        for (int i = 0; i < 10; i++){
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++){
                System.out.print(String.valueOf(gridStructure[i][j]));
                System.out.print("|");
            }
            System.out.println(" " + i);
        }
    }

     public void editArrayShot(ShotStates state, ShotCoordinate sc){
        this.gridStructure[sc.y][sc.x] = gridSymbols.get(state);
     };
     public void editArrayShip(ShotStates state, ShipCoordinate sc){
         for (int i = sc.y1; i < sc.y2 + 1; i ++){
             for (int j = sc.x1; j < sc.x2 + 1; j++){
                 this.gridStructure[i][j] = gridSymbols.get(state);
             }
         }
     }
    abstract void printHeader();
}
