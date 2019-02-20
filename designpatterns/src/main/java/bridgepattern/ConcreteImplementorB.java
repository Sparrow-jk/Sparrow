package bridgepattern;

/**
 * 具体实现化（Concrete Implementor）
 * 角色：给出实现化角色接口的具体实现。
 * @author Sparrow
 */
public class ConcreteImplementorB implements Implementor {

    /**
     * 目标方法
     */
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB实现了Implementor");
    }
}
