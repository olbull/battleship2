package ShotResults;

import Coordinate.ShotCoordinate;

public class NotSunkResult extends ShotResult{
    public final ShotStates state;
    public final ShotCoordinate shotco;

    public NotSunkResult(ShotStates state, ShotCoordinate shotco){
        this.state = state;
        this.shotco = shotco;
    }
}
