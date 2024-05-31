import java.util.*;

public class GameLogic {
    private List<String> words = Arrays.asList("kaczor", "minionki", "dom", "duch", "hasło", "burza", "czołg", "kotwica", "błyskawica");
    private String currentWord;
    private StringBuilder hiddenWord;
    private Set<Character> guessedLetters;
    private int remainingGuesses;

    public String getCurrentWord() {
        return currentWord;
    }

    public GameLogic() {
        guessedLetters = new HashSet<>();
        remainingGuesses = 6; // Maksymalna liczba niepoprawnych zgadywań
    }

    public void chooseWord() {
        Random random = new Random();
        currentWord = words.get(random.nextInt(words.size()));
        hiddenWord = new StringBuilder("_".repeat(currentWord.length()));
    }

    public boolean guessLetter(char letter) {
        boolean isCorrect = false;
        if (guessedLetters.add(letter)) { // Sprawdź, czy litera została już wcześniej zgadywana
            if (currentWord.indexOf(letter) >= 0) {
                isCorrect = true;
                for (int i = 0; i < currentWord.length(); i++) {
                    if (currentWord.charAt(i) == letter) {
                        hiddenWord.setCharAt(i, letter);
                    }
                }
            } else {
                remainingGuesses--;
            }
        }
        return isCorrect;
    }

    public String getHiddenWord() {
        return hiddenWord.toString();
    }

    public boolean isGameWon() {
        return !hiddenWord.toString().contains("_");
    }

    public boolean isGameOver() {
        return remainingGuesses <= 0 || isGameWon();
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }
}