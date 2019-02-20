package bridgepattern;

/**
 * 扩展抽象化（Refined    Abstraction）
 * 角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 *
 * @author Sparrow
 */
public class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    /**
     * 桥接方法
     */
    @Override
    public void operation() {
        super.implementor.operation();
    }
}
