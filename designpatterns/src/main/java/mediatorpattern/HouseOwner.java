package mediatorpattern;

/**
 * 房东
 * @author Sparrow
 */
public class HouseOwner extends AbstractCharacter {
    HouseOwner(String name, Mediator mediator) {
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
     * 获得信息
     * @param message 消息
     */
    public void getMessage(String message){
        System.out.println("房主:" + name +",获得信息：" + message);
    }
}
