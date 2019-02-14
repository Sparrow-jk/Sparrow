package mediatorpattern;

/**
 * 租客
 * @author Sparrow
 */
public class Tenant extends AbstractCharacter {
    Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * 与中介者联系
     * @param message 消息
     */
    @Override
    public void contact(String message){
        mediator.contact(message, this);
    }

    /**
     * 获取信息
     * @param message  消息
     */
    public void getMessage(String message){
        System.out.println("租房者:" + name +",获得信息：" + message);
    }
}
