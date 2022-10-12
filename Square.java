public class Square {

    // Fields
    Point topLeftCorner;
    int sideLength;

    // Pattern: Instance State Injection via Constructor
    public Square(Point topLeftCorner, int sideLength) {
        this.topLeftCorner = topLeftCorner;
        this.sideLength = sideLength;
    }
}
