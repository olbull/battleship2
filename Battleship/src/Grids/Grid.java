package Grids;
import Coordinate.ShipCoordinate;
import ShotResults.NotSunkResult;
import ShotResults.ShotStates;
import ShotResults.SunkResult;

import java.util.HashMap;

public abstract class Grid {
    private char[][] gridStructure = new char[10][10];
    private HashMap<ShotStates, java.lang.Character> gridSymbols = new HashMap<ShotStates, Character>();


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

    private void printBody(){
        for (int i = 0; i < 10; i++){
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++){
                System.out.print(String.valueOf(gridStructure[i][j]));
                System.out.print("|");
            }
            System.out.println(" " + i);
        }
    }

    public void addShip(ShipCoordinate shipco, char letter){
        for (int i = shipco.getY1(); i < shipco.getY2() + 1; i ++){
            for (int j = shipco.getX1(); j < shipco.getX2() + 1; j++){
                this.gridStructure[i][j] = letter;
            }
        }
    }

     public void editArrayShot(NotSunkResult nsr){
        this.gridStructure[nsr.shotco.getY()][nsr.shotco.getX()] = gridSymbols.get(nsr.state);
     };
     public void editArrayShip(SunkResult sr){
         for (int i = sr.shipco.getY1(); i < sr.shipco.getY2() + 1; i ++){
             for (int j = sr.shipco.getX1(); j < sr.shipco.getX2() + 1; j++){
                 this.gridStructure[i][j] = gridSymbols.get(sr.state);
             }
         }
     }
    abstract void printHeader();
}
