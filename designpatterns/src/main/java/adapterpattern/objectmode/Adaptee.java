package adapterpattern.objectmode;

import static java.lang.System.out;

/**
 * 适配者类
 * @author Sparrow
 */
public class Adaptee {
    public void specialRequest(){
        out.println("适配后被调用的方法");
    }
}
