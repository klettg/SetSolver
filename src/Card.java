
public class Card {
    private Color myColor;
    private Shape myShape;
    private Integer num;
    private Shade myShade;

    public Card(Color color, Shape shape, Integer num, Shade shade) {
        this.myColor = color;
        this.myShape = shape;
        this.num = num;
        this.myShade = shade;
    }

    public Color getMyColor() {

        return myColor;
    }

    public Shape getMyShape() {

        return myShape;
    }

    public Integer getNum() {

        return num;
    }

    public Shade getMyShade() {

        return myShade;
    }

    enum Color {
        PURPLE, GREEN, RED;
    }

    enum Shape {
        DIAMOND, OVAL, SQUIGGLE
    }

    enum Shade {
        SOLID,EMPTY, LIGHT
    }


    //print out one, two, three
    @Override
    public String toString() {

        return "Shape: " + this.getMyShape() + " Color: " + this.getMyColor() + " Num: " + this.getNum() + " Shade: " + this.myShade + "\n";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Card other = (Card) obj;

        return ((other.getMyColor() == this.getMyColor()) && (other.getMyShape() == this.getMyShape())
            && (other.getMyShade() == this.getMyShade()) && (this.getNum().equals(other.getNum())));
    }

    //TODO: Override HashCode?
    //TODO: Create method for comparing sets -> rather than using sets default
}
