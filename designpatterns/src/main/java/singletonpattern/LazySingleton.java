package singletonpattern;

/**
 * @author Sparrow
 * 懒汉单例
 * 在调用时候创建对象，以时间换空间
 * 此模式在多线程情况是线程不安全的
 * 参照双检锁单例 singletonpattern.DclSingleton
 */
@Deprecated
public class LazySingleton {
    /**
     * 单例模式的要义
     * 私有的构造器 使该单例类不会被外部创建
     * 除了反射调用
     */
    private LazySingleton() {
    }

    /**
     * 私有静态
     * 使该单例类在类加载初始化的时候便创建 空 的单例对象提供内部赋值使用
     */
    private static LazySingleton lazySingleton = null;

    /**
     * 公有静态
     *  提供外部调用私有的懒汉单例
     * @return lazySingleton 懒汉单例
     */
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            //调用时创建
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
