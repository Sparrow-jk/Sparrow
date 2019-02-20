package bridgepattern;

/**
 * 抽象化（Abstraction）
 * 角色：定义抽象类，并包含一个对实现化对象的引用。
 *
 * @author Sparrow
 */
public abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 桥接方法
     */
    public abstract void operation();
}
