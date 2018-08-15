import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardSet {
    private Set<Card> cards;

    public CardSet() {
        this.cards = new HashSet<Card>();
    }

    public CardSet(Set<Card> cards) {
        this.cards = cards;
    }

    public void remove(Card card) {
        cards.remove(card);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Set<Card> getCards() {
        return this.cards;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!CardSet.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final CardSet other = (CardSet) obj;

        if (other.getCards().size() != this.cards.size()) {
            return false;
        }
        Set<Card> remaining = other.createCopy().getCards();
        remaining.removeAll(getCards());
        return (remaining.isEmpty());
    }


   @Override
   //TODO: How is this different than default hashcode?
    public int hashCode() {

        int result = 7;
        int prime = 17;
        return result * prime + getCards().hashCode();
    }


    public int size() {
        return cards.size();
    }

    public CardSet createCopy() {

        CardSet other = new CardSet();
        for (Card c : getCards()) {
            other.getCards().add(c.clone());
        }
        return other;
    }

    //Checks if each characteristic of a card is same or different between three cards in CardSet
    public boolean isSolution() {

        List<Card> listOfCards = new ArrayList();
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
}
