package compositepattern;

/**
 * @author Sparrow
 * @description 组织的抽象
 * @description Component
 */
public abstract class AbstractOrganization {

    /**
     * 注册Component
     * @param organization Component
     */
    public void add(AbstractOrganization organization){
        throw new UnsupportedOperationException();
    }
    /**
     * 移除Component
     * @param organization Component
     */
    public void remove(AbstractOrganization organization){
        throw new UnsupportedOperationException();
    }

    /**
     * Component 属性
     * @return 名称
     */
    public String getName(){
        throw new UnsupportedOperationException();
    }

    /**
     * 输出
     */
    public void print(){
        throw new UnsupportedOperationException();
    }

}
