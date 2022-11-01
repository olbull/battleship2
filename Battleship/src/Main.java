import Games.Game;
public class Main {
    public static void main(String[] args) {
        new Game();
        if(Game.playAgain()) {new Game();}
    }
}