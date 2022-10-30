package Games;
import java.util.Random;
import java.util.Scanner;

import Coordinate.ShotCoordinate;
import Players.*;
import Grids.*;
import ShotResults.NotSunkResult;
import ShotResults.ShotResult;
import ShotResults.ShotStates;
import ShotResults.SunkResult;


public class Game { //Singleton!
    boolean gameState;
    private OceanGrid og;
    private TargetGrid tg;

    HumanPlayer human; cpuPlayer cpu;

    public Game() {
        gameState = true;

        this.human = new HumanPlayer();
        this.cpu = new cpuPlayer();

        og = human.placefleet();
        tg = cpu.placefleet();

        runGameRandom();
    }

    public void runGameRandom(){
        Random rand = new Random();
        int decider = rand.nextInt(2);
        if (decider == 0) {
            runGameCpuBegins();
        }
        else{runGameHumanBegins();}
    }

    public void runGameHumanBegins(){
        System.out.println("You begin!");
        while (gameState) {
            humanTurn();
            if (! gameState){
                System.out.println("Game over! You won.");
                break;
            }
            cpuTurn();
            if (! gameState){
                System.out.println("Game over! CPU won.");
            }
        }
    }

    public void runGameCpuBegins(){
        System.out.println("CPU begins!");
        while (gameState) {
            cpuTurn();
            if (! gameState){
                System.out.println("Game over! CPU won.");
                break;
            }
            humanTurn();
            if (! gameState){
                System.out.println("Game over! You won.");
            }
        }
    }

    public void humanTurn(){
        ShotCoordinate shotco = human.shoot();
        SunkResult sr = cpu.isSunk(shotco);
        if(sr.state == ShotStates.HIT || sr.state == ShotStates.MISS) {
            NotSunkResult nsr = new NotSunkResult(sr.state, shotco);
            tg.editArrayShot(nsr);
        }
        else{
            tg.editArrayShip(sr);
        }
        tg.draw(); og.draw();
        gameState = cpu.isAlive();
    }

    public void cpuTurn(){
        ShotCoordinate shotco = cpu.shoot();
        SunkResult sr = human.isSunk(shotco);
        if(sr.state == ShotStates.HIT || sr.state == ShotStates.MISS) {
            NotSunkResult nsr = new NotSunkResult(sr.state, shotco);
            og.editArrayShot(nsr);
        }
        else{
            og.editArrayShip(sr);
        }
        tg.draw(); og.draw();
        gameState = human.isAlive();

    }
    public boolean playAgain(){
        System.out.println("Would you like play again? Type YES or NO...");
        Scanner InputScanner = new Scanner(System.in);
        String stringInput = InputScanner.nextLine();
        if (stringInput == "YES"){
            return true;
        }
        else{
            System.out.println("See you next time!");
            return false;
        }
    }
}
