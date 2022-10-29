package ShotResults;
import Coordinate.*;

public class HitResult {
    public final ShotStates state;
    public final ShipCoordinate shipco;

    public HitResult(ShotStates state, ShipCoordinate coord) {
        this.state = state;
        this.shipco = coord;

    }
}
