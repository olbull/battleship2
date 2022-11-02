package ShotResults;
import Coordinate.*;

public class SunkResult extends ShotResult{

    public final ShotStates state; // ShotStates is immutable
    public final ShipCoordinate shipco; // ShipCoordinate is immutable


    public SunkResult(ShotStates state, ShipCoordinate shipco){
        this.state = state;
        this.shipco = shipco;
    }
}
