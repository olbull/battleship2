package Ships;

public class PatrolBoat extends Ship {
    public PatrolBoat(){
        this.length = 2;
        this.letter = 'P';
        this.state = BoatState.INTACT;
    }
}
