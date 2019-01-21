package facadepattern;

/**
 * @author Sparrow
 */
public class Maker {
    private Triangle triangle;
    private  Square square;
    private  Circle circle;

    public Maker(){
        this.triangle = new Triangle();
        this.square = new Square();
        this.circle = new Circle();
    }
    public void makeTriangle(){
        triangle.makeShape();
    }

    public void makeSquare(){
        square.makeShape();
    }

    public void makeCircle(){
        circle.makeShape();
    }

}
