import java.util.HashSet;
import java.util.Set;

public class Main {

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

        SetGame game = new SetGame(new CardSet(deck));
        game.solve();
    }


}
