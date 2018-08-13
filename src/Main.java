import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static boolean SOLUTIONS_EXIST = false;
    private static Set<String> SOLUTIONS = new HashSet<String>();

    public static void main(String[] args) {

        Set<Card> deck = new HashSet<Card>();
        deck.add(new Card(Card.Color.PURPLE, Card.Shape.DIAMOND, 2, Card.Shade.EMPTY));
        deck.add(new Card(Card.Color.PURPLE, Card.Shape.SQUIGGLE, 2, Card.Shade.EMPTY));
        deck.add(new Card(Card.Color.RED, Card.Shape.OVAL, 3, Card.Shade.LIGHT));
        deck.add(new Card(Card.Color.GREEN, Card.Shape.OVAL, 2, Card.Shade.SOLID));
        deck.add(new Card(Card.Color.RED, Card.Shape.DIAMOND, 1, Card.Shade.EMPTY));
        deck.add(new Card(Card.Color.GREEN, Card.Shape.SQUIGGLE, 3, Card.Shade.LIGHT));
        deck.add(new Card(Card.Color.GREEN, Card.Shape.OVAL, 3, Card.Shade.SOLID));
        deck.add(new Card(Card.Color.PURPLE, Card.Shape.DIAMOND, 3, Card.Shade.SOLID));
        deck.add(new Card(Card.Color.RED, Card.Shape.SQUIGGLE, 1, Card.Shade.EMPTY));
        deck.add(new Card(Card.Color.PURPLE, Card.Shape.SQUIGGLE, 1, Card.Shade.SOLID));
        deck.add(new Card(Card.Color.PURPLE, Card.Shape.OVAL, 2, Card.Shade.EMPTY));
        deck.add(new Card(Card.Color.GREEN, Card.Shape.SQUIGGLE, 2, Card.Shade.EMPTY));

        checkForSets(new HashSet<Card>(), deck);
        printSolutions();

    }

    //implements recursive backtracking
    private static void checkForSets(Set<Card> currPair, Set<Card> deck) {
        if (currPair.size() == 3) {
            if (isSolution(currPair)) {
                //Set is checking if we've already seen before automatically
                //Better way than to use global flag?
                SOLUTIONS.add(addSolutions(currPair));
                SOLUTIONS_EXIST = true;
            }
        }
        else {
            for (Card card : deck) {
                currPair.add(card);
                Set<Card> updatedDeck = new HashSet<Card>();

                //copying list each iteration -> better way to do this?
                for (Card c: deck) {
                    updatedDeck.add(c);
                }
                updatedDeck.remove(card);
                checkForSets(currPair, updatedDeck);
                currPair.remove(card);
            }
        }
    }
    
    private static boolean isSolution(Set<Card> cards) {
        List<Card> listOfCards = new ArrayList<Card>();
        listOfCards.addAll(cards);

        Card a = listOfCards.get(0);
        Card b = listOfCards.get(1);
        Card c = listOfCards.get(2);

        //check if color are all same or different
        if ((a.getMyColor().equals(b.getMyColor()) && a.getMyColor().equals(c.getMyColor()))
                || (!a.getMyColor().equals(b.getMyColor()) && !b.getMyColor().equals(c.getMyColor()) && !a.getMyColor().equals(c.getMyColor()))) {

            //check if shapes are all same or different
            if ((a.getMyShape().equals(b.getMyShape()) && a.getMyShape().equals(c.getMyShape()))
                    || (!a.getMyShape().equals(b.getMyShape()) && !b.getMyShape().equals(c.getMyShape()) && !a.getMyShape().equals(c.getMyShape()))) {

                //check if nums are all same or different
                if ((a.getNum() == b.getNum() && a.getNum() == c.getNum())
                        || (a.getNum() != b.getNum() && a.getNum() != c.getNum() && b.getNum() != c.getNum())) {

                    if ((a.getMyShade().equals(b.getMyShade()) && a.getMyShade().equals(c.getMyShade()))
                            || (!a.getMyShade().equals(b.getMyShade()) && !b.getMyShade().equals(c.getMyShade()) && !a.getMyShade().equals(c.getMyShade()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String addSolutions(Set<Card> solution) {

        StringBuilder output = new StringBuilder();
        output.append("\nSolution: \n");
        for (Card card : solution) {
            output.append(card.toString());
        }
        output.append("\n");
        return output.toString();
    }

    private static void printSolutions() {
        for (String sol : SOLUTIONS) {
            System.out.print(sol);
        }
    }
}
