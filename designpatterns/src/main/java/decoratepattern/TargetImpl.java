package decoratepattern;

/**
 * 目标方法实现
 * @author Sparrow
 */
public class TargetImpl implements Target {
    /**
     * 目标方法
     */
    @Override
    public void targetMethod() {
        System.out.println("Target接口被Targetimpl类实现");
    }
}
