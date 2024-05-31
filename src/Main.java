public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        UI ui = new UI(gameLogic);
        ui.startGame();
    }
}