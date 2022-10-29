package Games;
import Players.*;
import Grids.*;

public class Game { //Singleton!
    HumanPlayer p1; //beginningPlayer...?
    cpuPlayer p2;
    boolean gameState;
    OceanGrid og;
    TargetGrid tg;

    Player selectBeginningPlayer(){return null;} //besser im Konstruktor...?
    public void rungame(Player beginningPlayer){};
}
