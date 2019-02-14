package mediatorpattern;

/**
 * 中介者
 * @author Sparrow
 */
public interface  Mediator {
    /**
     * 联络方法
     * @param message 消息
     * @param character 人物
     */
      void contact (String message,AbstractCharacter character);
}
