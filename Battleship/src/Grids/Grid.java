package Grids;
import Coordinate.ShipCoordinate;
import ShotResults.NotSunkResult;
import ShotResults.ShotStates;
import ShotResults.SunkResult;

import java.util.HashMap;

public abstract class Grid {
    private final char[][] gridStructure = new char[10][10];
    private final HashMap<ShotStates, java.lang.Character> gridSymbols = new HashMap<>();

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
        System.out.println("  +-+-+-+-+-+-+-+-+-+-+   ");
        printBody();
        System.out.println("  +-+-+-+-+-+-+-+-+-+-+   ");
        System.out.println("   A B C D E F G H I J   ");
        printFoot();
        System.out.println();

    }

    private void printBody(){
        for (int i = 0; i < 10; i++){
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++){
                System.out.print(gridStructure[i][j]);
                System.out.print("|");
            }
            System.out.println(" " + i);
        }
    }

    private void printFoot(){
        System.out.println("   ===================");
    }

    public void addShip(ShipCoordinate shipco, char letter){
        for (int i = shipco.y1; i < shipco.y2 + 1; i ++){
            for (int j = shipco.x1; j < shipco.x2 + 1; j++){
                this.gridStructure[i][j] = letter;
            }
        }
    }

     public void editArrayShot(NotSunkResult nsr){
        this.gridStructure[nsr.shotco.y][nsr.shotco.x] = gridSymbols.get(nsr.state);
     }
     public void editArrayShip(SunkResult sr){
         for (int i = sr.shipco.y1; i < sr.shipco.y2 + 1; i ++){
             for (int j = sr.shipco.x1; j < sr.shipco.x2 + 1; j++){
                 this.gridStructure[i][j] = gridSymbols.get(sr.state);
             }
         }
     }
    abstract void printHeader();
}
