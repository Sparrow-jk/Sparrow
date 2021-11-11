package singletonpattern;

/**
 * 枚举单例
 * 解决了反射问题 同时是线程安全的单例
 * 代码简洁
 *
 * @author Sparrow
 */

public enum EnumSingleton {
    //枚举单例
    INSTANCE;

    private String name ="sss";

    public String getName() {
        return name;
    }

}


class Test {

    public static void main(String[] args) {


        System.out.println(EnumSingleton.INSTANCE.getName());
    }

}
