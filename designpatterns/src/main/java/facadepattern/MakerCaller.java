package facadepattern;

/**
 * @author Sparrow
 */
public class MakerCaller  {
    public static void main(String[] args){
        Maker maker = new Maker();
        maker.makeCircle();
        maker.makeSquare();
        maker.makeTriangle();
    }
}
