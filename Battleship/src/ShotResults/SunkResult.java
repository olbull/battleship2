package ShotResults;
import Coordinate.*;

public class SunkResult extends ShotResult{

    public final ShotStates state;
    public final ShipCoordinate shipco;


    public SunkResult(ShotStates state, ShipCoordinate shipco){
        this.state = state;
        this.shipco = shipco;
    }
}
