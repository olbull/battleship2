package Coordinate;

import java.util.ArrayList;
import java.util.Comparator;

public class ShotCoordinate extends Coordinate {

    public final int x; public final int y;
    InputBehavior ib;

    public ShotCoordinate(InputBehavior injectedBehavior){
        this.ib = injectedBehavior;
        ArrayList<Integer> coordinates = ib.generateShotCoordinate();
        x = coordinates.get(0);
        y = coordinates.get(1);
    }

    public boolean equals(Object sc){
        if (sc == null) {return false;}
        else if (sc == this) {return true;}
        else if (sc.getClass() != getClass()){return false;}
        return this.x == ((ShotCoordinate)sc) .x && this.y == ((ShotCoordinate)sc) .y;
        }
    }
