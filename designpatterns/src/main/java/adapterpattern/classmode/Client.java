package adapterpattern.classmode;

/**
 * 调用者类
 * @author Sparrow
 */
public class Client {
    public static void main(String[] args) {
        Adapter classAdapter = new Adapter();
        //调用了适配者类的specialRequest
        classAdapter.request();
    }
}
