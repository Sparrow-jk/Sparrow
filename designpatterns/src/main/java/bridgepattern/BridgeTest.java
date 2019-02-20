package bridgepattern;

/**
 * 测试类
 *
 * @author Sparrow
 */
public class BridgeTest {
    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementorA());
        abstraction.operation();


        abstraction = new RefinedAbstraction(new ConcreteImplementorB());
        abstraction.operation();
    }
}
