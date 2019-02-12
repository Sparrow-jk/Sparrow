package adapterpattern.classmode;

/**
 * 类适配器
 * @author Sparrow
 */
public class Adapter extends Adaptee implements Target{

    /**
     * 被调用的方法
     */
    @Override
    public void request() {
        super.specialRequest();
    }
}
