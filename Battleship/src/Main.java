
import Coordinate.*;
import Fleet.*;
import Grids.*;
import Ships.*;
import Games.Game;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        new Game();
        if(Game.playAgain()) {new Game();}
    }
}