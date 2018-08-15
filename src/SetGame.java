import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetGame {
    private Set<Card> deck;
    //should this solutions be static?
    private static Set<String> SOLUTIONS = new HashSet();

    public SetGame(Set<Card> deck) {
        this.deck = deck;
    }

    public void solve() {
        Set<Card> currPair = new HashSet();
        checkForSets(currPair, deck);
        printSolutions();
    }

    //implements recursive backtracking
    private void checkForSets(Set<Card> currPair, Set<Card> deck) {
        if (currPair.size() == 3) {
            if (isSolution(currPair)) {
                //TODO: Implement repeat check
                SOLUTIONS.add(addSolutions(currPair));
            }
        }
        else {
            for (Card card : deck) {
                currPair.add(card);
                Set<Card> updatedDeck = new HashSet();

                //TODO: copying list each iteration -> better way to do this?
                for (Card c: deck) {
                    updatedDeck.add(c);
                }
                updatedDeck.remove(card);
                checkForSets(currPair, updatedDeck);
                currPair.remove(card);
            }
        }
    }


    private boolean isSolution(Set<Card> cards) {
        List<Card> listOfCards = new ArrayList<Card>();
        listOfCards.addAll(cards);

        Card a = listOfCards.get(0);
        Card b = listOfCards.get(1);
        Card c = listOfCards.get(2);

        //return true if all characteristics are different or same
        return (colorsSameOrDifferent(a, b, c) && shapesSameOrDifferent(a, b, c) && numsSameOrDifferent(a, b, c) && shadesSameOrDifferent(a, b, c));
    }

    private boolean colorsSameOrDifferent(Card a, Card b, Card c) {
        return (a.getMyColor().equals(b.getMyColor()) && a.getMyColor().equals(c.getMyColor()))
                || (!a.getMyColor().equals(b.getMyColor()) && !b.getMyColor().equals(c.getMyColor()) && !a.getMyColor().equals(c.getMyColor()));
    }

    private boolean shapesSameOrDifferent(Card a, Card b, Card c) {
       return (a.getMyShape().equals(b.getMyShape()) && a.getMyShape().equals(c.getMyShape()))
                    || (!a.getMyShape().equals(b.getMyShape()) && !b.getMyShape().equals(c.getMyShape()) && !a.getMyShape().equals(c.getMyShape()));
    }

    private boolean numsSameOrDifferent(Card a, Card b, Card c) {
        return (a.getNum() == b.getNum() && a.getNum() == c.getNum())
                || (a.getNum() != b.getNum() && a.getNum() != c.getNum() && b.getNum() != c.getNum());
    }

    private boolean shadesSameOrDifferent(Card a, Card b, Card c) {
        return (a.getMyShade().equals(b.getMyShade()) && a.getMyShade().equals(c.getMyShade()))
                || (!a.getMyShade().equals(b.getMyShade()) && !b.getMyShade().equals(c.getMyShade()) && !a.getMyShade().equals(c.getMyShade()));
    }

    private String addSolutions(Set<Card> solution) {

        StringBuilder output = new StringBuilder();
        output.append("\nSolution: \n");
        for (Card card : solution) {
            output.append(card.toString());
        }
        output.append("\n");
        return output.toString();
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
                for (String sol : SOLUTIONS) {
                    System.out.print(sol);
                }
            }
        }
    }
}
