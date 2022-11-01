package Grids;

public class OceanGrid extends Grid{

    public OceanGrid() {
        super();
        char[][] gridStructure = new char[10][10];
    }

    protected void printHeader(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("===== OCEAN  GRID ====="); // ===== OCEAN GRID =====
        //System.out.println();
    }
}

