
import org.junit.Assert;
import org.junit.Test;

public class setLogicTest {

    @Test
    public void cardEquals() {
        //equals test
        Card a = new Card(Card.Color.PURPLE, Card.Shape.DIAMOND, 2, Card.Shade.EMPTY);
        Card b = new Card(Card.Color.PURPLE, Card.Shape.DIAMOND, 2, Card.Shade.EMPTY);
        Card c = new Card(Card.Color.RED, Card.Shape.DIAMOND, 2, Card.Shade.EMPTY);
        Assert.assertTrue(a.equals(b));
        Assert.assertFalse(a.equals(c));
    }

    //TODO: ADD test to check if containsSets works
}
