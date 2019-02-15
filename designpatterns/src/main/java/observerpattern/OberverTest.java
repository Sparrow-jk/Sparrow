package observerpattern;

public class OberverTest {
    public static void main(String[] args) {
        Watcher watcher1 = new Watcher("小赵");
        Watcher watcher2 = new Watcher("小钱");
        Watcher watcher3 = new Watcher("小孙");
        Watcher watcher4 = new Watcher("小李");
        TvPlay tvPlay = new TvPlay("同福客栈");
        tvPlay.registerWatcher(watcher1);
        tvPlay.registerWatcher(watcher2);
        tvPlay.registerWatcher(watcher3);
        tvPlay.registerWatcher(watcher4);
        tvPlay.notifyWatchers(1);
        tvPlay.cancelWatcher(watcher4);
    }
}
