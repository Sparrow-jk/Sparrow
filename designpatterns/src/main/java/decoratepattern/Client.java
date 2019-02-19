package decoratepattern;

/**
 * 装饰者模式客户端
 * @author Sparrow
 */
public class Client {
    public static void main(String[] args) {
        Target decorate = new Decorate(new TargetImpl());
        decorate.targetMethod();
    }
}
