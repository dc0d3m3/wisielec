import java.util.Scanner;

public class UI {
    private GameLogic gameLogic;
    private Scanner scanner;

    public UI(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        gameLogic.chooseWord();
        while (!gameLogic.isGameOver()) {
            System.out.println("\nUkryte słowo: " + gameLogic.getHiddenWord());
            System.out.print("Podaj literę: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);
            if (!gameLogic.guessLetter(guess)) {
                System.out.println("Niepoprawna litera. Pozostało prób: " + gameLogic.getRemainingGuesses());
            }
        }

        if (gameLogic.isGameWon()) {
            System.out.println("Gratulacje! Wygrałeś! Słowo to: " + gameLogic.getCurrentWord());
        } else {
            System.out.println("Przegrałeś. Słowo to było: " + gameLogic.getCurrentWord());
        }
    }
}