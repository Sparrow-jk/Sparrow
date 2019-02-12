package adapterpattern.objectmode;

/**
 * 类适配器
 * @author Sparrow
 */
public class Adapter implements  Target{
    /**
     * 引入适配者类
     */
    private  Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 被调用的方法
     */
    @Override
    public void request() {
        //调用被引入的适配者类的方法
        adaptee.specialRequest();
    }
}
