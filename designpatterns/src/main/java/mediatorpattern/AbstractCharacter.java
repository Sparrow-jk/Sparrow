package mediatorpattern;

/**
 * 抽象角色
 * @author Sparrow
 */
public abstract class AbstractCharacter {
    protected String name;
    protected Mediator mediator;

    public AbstractCharacter(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    /**
     * 角色间联系方法
     * @param message 消息
     */
    public  abstract void contact(String message);
}
