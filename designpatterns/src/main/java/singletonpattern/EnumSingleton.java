package singletonpattern;

/**
 * 枚举单例
 * 解决了反射问题 同时是线程安全的单例
 * 代码简洁
 * @author Sparrow
 */

public enum EnumSingleton {
    //枚举单例
    ENUM_SINGLETON;
    //使用时调用
    public EnumSingleton getInstance(){
        return ENUM_SINGLETON;
    }
}
