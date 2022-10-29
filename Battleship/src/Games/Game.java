package Games;
import java.util.Random;

import Coordinate.ShotCoordinate;
import Players.*;
import Grids.*;
import ShotResults.HitResult;
import ShotResults.ShotStates;


public class Game { //Singleton!
    boolean gameState;
    OceanGrid og;
    TargetGrid tg;

    Player beginner; Player other;

    public Game() {
        og = new OceanGrid();
        tg = new TargetGrid();


        selectBeginningPlayer();



        gameState = true;


    }

    public void selectBeginningPlayer(){
        Random rand = new Random();
        int decider = rand.nextInt(2);
        if (decider == 0) {
            this.beginner = new cpuPlayer();
            this.other = new HumanPlayer();
            System.out.println("\nCPU begins!\n");
        }
        this.beginner = new HumanPlayer();
        this.other = new cpuPlayer();
        System.out.println("\nYou begin!\n");
    }
    public void rungame(Player beginningPlayer){
        while (gameState) {
            ShotCoordinate shotco = beginner.shoot(); //player 1 shoots
            HitResult sr = other.handleHit(shotco); // shot is handled
            if(sr.state == ShotStates.SUNKFLEET) { // beginner wins
                gameState = false;
                break;
            }
            if (beginningPlayer instanceof HumanPlayer) {
                if(
                        sr.state == ShotStates.SUNKBS ||
                        sr.state == ShotStates.SUNKC ||
                        sr.state == ShotStates.SUNKPB ||
                        sr.state == ShotStates.SUNKSM) {

                }
                    instanceof ShotCoordinate) {tg.editArrayShot(sr.state, sr.coord);}
            };

        }
    };
}
