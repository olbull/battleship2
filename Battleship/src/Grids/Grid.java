package Grids;
import Coordinate.ShipCoordinate;
import Coordinate.ShotCoordinate;

public abstract class Grid {
    char[][] gridStructure = new char[10][10];


    //private ArrayList<ShipCoordinate> ships; //oder besser als zweites, bereits platziertes Array?

    public Grid(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                this.gridStructure[i][j] = ' ';
            }
        }
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

     public void editArrayShot(ShotCoordinate coords, char hitormiss){
         this.gridStructure[coords.y][coords.x] = hitormiss;
     };
     public void editArrayShip(ShipCoordinate coords, char shipchar){
         for (int i = coords.y1; i < coords.y2 + 1; i ++){
             for (int j = coords.x1; j < coords.x2 + 1; j++){
                 this.gridStructure[i][j] = shipchar;
             }
         }
     }
    abstract void printHeader();
}
