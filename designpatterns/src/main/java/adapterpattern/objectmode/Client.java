package adapterpattern.objectmode;

/**
 * 调用者类
 * @author Sparrow
 */
public class Client {
    public static void main(String[] args) {
        Adapter objectAdapter = new Adapter(new Adaptee());
        //调用了适配者类的specialRequest
        objectAdapter.request();
    }
}
