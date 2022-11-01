package Games;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Coordinate.Coordinate;
import Coordinate.HumanBehavior;
import Coordinate.ShotCoordinate;
import Players.*;
import Grids.*;
import ShotResults.NotSunkResult;
import ShotResults.ShotStates;
import ShotResults.SunkResult;


public class Game { //Singleton!
    private boolean gameState;
    private OceanGrid og;
    private TargetGrid tg;

    private HashMap<Integer, Character> translation; // = new HashMap<Integer, Character>();

    HumanPlayer human; cpuPlayer cpu;

    public Game() {
        gameState = true;

        this.human = new HumanPlayer();
        this.cpu = new cpuPlayer();
        this.translation = new HashMap<Integer, Character>();
        setTranslation();
        //tg.draw(); og.draw();

        og = human.placeFleet();
        tg = cpu.placeFleet();

        runGameRandom();
    }

    private void setTranslation(){
        translation = new HashMap<Integer, Character>();
        translation.put(0, 'A'); //HashMap wird hier gefüllt, da Coordinates.Coordinate.cpuBehavior diese nicht braucht(!) (und wir keine bessere Lösung haben...)
        translation.put(1, 'B');
        translation.put(2, 'C');
        translation.put(3, 'D');
        translation.put(4, 'E');
        translation.put(5, 'F');
        translation.put(6, 'G');
        translation.put(7, 'H');
        translation.put(8, 'I');
        translation.put(9, 'J');
    }
    private void runGameRandom(){
        Random rand = new Random();
        int decider = rand.nextInt(2);
        if (decider == 0) {
            runGameCpuBegins();
        }
        else{runGameHumanBegins();}
    }


    private void runGameHumanBegins(){
        System.out.println("You begin!\n");
        while (gameState) {
            humanTurn();
            if (! gameState){
                System.out.println("Game over! You won.\n");
                break;
            }
            cpuTurn();
            if (! gameState){
                System.out.println("Game over! CPU won.\n");
            }
        }
    }


    private void runGameCpuBegins(){
        System.out.println("CPU begins!\n");
        while (gameState) {
            cpuTurn();
            if (! gameState){
                System.out.println("Game over! CPU won.\n");
                break;
            }
            humanTurn();
            if (! gameState){
                System.out.println("Game over! You won.\n");
            }
        }
    }

    private void humanTurn(){
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

    private void cpuTurn(){
        ShotCoordinate shotco = cpu.shoot();
        SunkResult sr = human.isSunk(shotco);
        String output = "";
        if(sr.state == ShotStates.HIT || sr.state == ShotStates.MISS) {
            String tempCo = this.translation.get(shotco.x) + Integer.toString(shotco.y);

            if (sr.state == ShotStates.HIT){
                output = "You have been hit at " + tempCo + "!";
            }
            else{
                output = "CPU Player missed your fleet at " + tempCo+ ".";
            }
            NotSunkResult nsr = new NotSunkResult(sr.state, shotco);
            og.editArrayShot(nsr);
        }
        else{
            og.editArrayShip(sr);
            output = "Ship sunk!!";
        }
        tg.draw(); og.draw();
        System.out.println(output);
        gameState = human.isAlive();

    }

    public static boolean playAgain(){
        System.out.println("Would you like play again? Type YES or NO...");
        Scanner InputScanner = new Scanner(System.in);
        String stringInput = InputScanner.nextLine();
        System.out.println(stringInput);
        if (stringInput.equals("YES")){
            return true;
        }
        else{
            System.out.println("See you next time!");
            return false;
        }
    }
}
