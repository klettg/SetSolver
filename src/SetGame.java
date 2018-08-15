import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetGame {

    private CardSet deck;
    private static Set<CardSet> SOLUTIONS = new HashSet();

    public SetGame(CardSet deck) {

        this.deck = deck;
    }

    public void solve() {
        CardSet currPair = new CardSet();
        checkForSets(currPair, deck);
        printSolutions();
    }

    //implements recursive backtracking
    private void checkForSets(CardSet currPair, CardSet deck) {
        if (currPair.size() == 3) {
            if (currPair.isSolution()) {
                SOLUTIONS.add(currPair.createCopy());
            }
        }
        else {
            for (Card card : deck.getCards()) {
                currPair.add(card);
                CardSet updatedDeck = deck.createCopy();
                updatedDeck.remove(card);
                checkForSets(currPair, updatedDeck);
                currPair.remove(card);
            }
        }
    }



    private void printSolutions() {
        if (SOLUTIONS.isEmpty()) {
            System.out.println("There are no solutions");
        } else {
            System.out.println(SOLUTIONS.size() + " Solution(s) exist.");
            System.out.println("Would you like to see the solutions?");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                for (CardSet sol : SOLUTIONS) {
                    for (Card card : sol.getCards()) {
                        System.out.println(card.toString());
                    }
                    System.out.println();
                }
            }
        }
    }
}
