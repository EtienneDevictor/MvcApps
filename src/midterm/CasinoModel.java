package midterm;

import mvc.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CasinoModel extends Model {
    private int die1;
    private int die2;
    private int score;
    private List<CasinoView> observers;

    public CasinoModel() {
        observers = new ArrayList<>();
    }

    public void rollDice() {
        Random random = new Random();
        die1 = random.nextInt(6) + 1; // Generate a random number between 1 and 6 (inclusive)
        die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;

        if (sum == 7 || sum == 11) {
            score++;
        } else if (sum == 3 || sum == 12) {
            score = 0;
        }
        notifyObservers();
    }
    public void addObserver(CasinoView observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (CasinoView observer : observers) {
            observer.updateView(die1, die2, score);
        }
    }
    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getScore() {
        return score;
    }
}
