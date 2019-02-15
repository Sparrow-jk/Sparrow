package observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 *视频订阅
 * @author Sparrow
 */
public class TvPlay extends Observable {
    private String name;
    private int episodes;

    public TvPlay(String name) {
        this.name = name;
    }

    /**
     * 观众订阅
     * @param observer 观众
     */
    public void registerWatcher(Observer observer){
        if (observer instanceof  Watcher){
            super.addObserver(observer);
            System.out.println("欢迎"+((Watcher) observer).getName()+"订阅"+getName());
        }
    }

    /**
     * 观众取消订阅
     * @param observer 观众
     */
    public void cancelWatcher(Observer observer){
        if (observer instanceof  Watcher){
            super.deleteObserver(observer);
            System.out.println(((Watcher) observer).getName()+"您已经取消订阅"+getName());
        }
    }

    /**
     * 提醒更新
     */
    public void notifyWatchers(int episodes){
        setEpisodes(episodes);
        super.notifyObservers(getEpisodes());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        super.setChanged();
        this.episodes = episodes;
    }
}
