package decoratepattern;

/**
 * 装饰器类
 * @author Sparrow
 */
public class Decorate implements Target{
    /**
     * 目标接口
     */
    private Target target;

    public Decorate(Target target) {
        this.target = target;
    }


    /**
     * 目标方法
     */
    @Override
    public void targetMethod() {
        System.out.println("Target接口由Decorate实现(装饰)");
        target.targetMethod();
        System.out.println("Target接口由Decorate实现(装饰)");
    }
}
