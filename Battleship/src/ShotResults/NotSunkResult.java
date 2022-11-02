package ShotResults;
import Coordinate.ShotCoordinate;
public class NotSunkResult extends ShotResult{
    public final ShotStates state; // ShotStates is immutable
    public final ShotCoordinate shotco; // ShotCoordinate is immutable

    public NotSunkResult(ShotStates state, ShotCoordinate shotco){
        this.state = state;
        this.shotco = shotco;
    }
}
