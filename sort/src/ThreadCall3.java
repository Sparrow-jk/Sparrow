import java.util.concurrent.locks.LockSupport;

public class ThreadCall3 {


    private static int a = 1;

    private static Thread t1, t2;


    public static void main(String[] args) throws InterruptedException {

        t1 = new Thread(() -> {

            while (true) {
                if (a > 100) {
                    return;
                }
                System.out.println(a++);
                LockSupport.unpark(t2);
                LockSupport.park();
            }


        }, "t1");

        t2 = new Thread(() -> {

            while (true) {
                if (a > 100) {
                    return;
                }
                LockSupport.park();
                System.out.println(a++);
                LockSupport.unpark(t1);
            }


        }, "t2");

        t1.start();
        t2.start();


    }


}
