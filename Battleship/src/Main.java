import Games.Game;

public class Main {
    public static void main(String[] args) {
        boolean isPlaying = true;
        while (isPlaying){
            new Game();
            isPlaying = Game.playAgain();
    }
}
}
