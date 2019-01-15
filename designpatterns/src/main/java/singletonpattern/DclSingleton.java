package singletonpattern;


/**
 * 双检锁单例 double check lock
 * 基于懒汉模式的线程安全单例
 *
 * @author Sparrow
 */
public class DclSingleton {

    /**
     * 构造方法私有化
     * 私有的构造器 使该单例类不会被外部创建
     * 除了反射调用
     */
    private DclSingleton() {
    }

    /**
     * 实例化的变量引用私有化
     * 使该单例类在类加载初始化的时候便创建 空 的单例对象提供内部赋值使用
     */
    private static DclSingleton dclSingleton;

    /**
     * 获取实例的方法共有
     * 提供外部调用私有的懒汉单例
     *
     * @return 双检锁单例
     */
    public static DclSingleton getInstance() {
        //此判断优化同步锁的情况下性能低下
        if (dclSingleton == null) {
            //保证线程安全
            synchronized (DclSingleton.class) {
                //此判断在单例为空的情况下线程安全
                if (dclSingleton == null) {
                    // 调用时创建
                    dclSingleton = new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
