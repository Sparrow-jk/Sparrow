package bridgepattern;

/**
 * 具体实现化（Concrete Implementor）
 * 角色：给出实现化角色接口的具体实现。
 *
 * @author Sparrow
 */
public class ConcreteImplementorA implements Implementor {

    /**
     * 目标方法
     */
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA实现了Implementor");
    }
}
