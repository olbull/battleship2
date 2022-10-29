package Coordinate;

import java.util.ArrayList;
public class ShipCoordinate extends Coordinate {
    public final int x1;
    public final int y1;
    public final int x2;
    public final int y2;
    InputBehavior ib;

    public ShipCoordinate(InputBehavior injectedBehavior) {
        ib = injectedBehavior;
        ArrayList<Integer> coordinates = ib.generateShipCoordinate();
        x1 = coordinates.get(0);
        y1 = coordinates.get(1);
        x2 = coordinates.get(2);
        y2 = coordinates.get(3);
    }
}