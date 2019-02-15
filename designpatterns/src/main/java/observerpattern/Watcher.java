package observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 观众
 * @author Sparrow
 */
public class Watcher implements Observer {

    private String name;

    public Watcher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        int episodes = (int) arg;
        if (o instanceof TvPlay){
            TvPlay tvPlay = (TvPlay) o;
            System.out.println(getName()+"您好,"+tvPlay.getName()+"已更新到"+episodes+"集");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
