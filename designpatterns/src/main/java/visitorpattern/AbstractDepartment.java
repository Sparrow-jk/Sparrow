package visitorpattern;

/**
 * 抽象部门
 *
 * @author Sparrow
 * @description Visitor（抽象访问者）
 * @description 抽象访问者为对象结构中每一个具体元素类ConcreteElement声明一个访问操作。 从这个操作的名称或参数类型可以清楚知道需要访问的具体元素的类型，
 * 具体访问者则需要实现这些操作方法，定义对这些元素的访问操作。
 */


public abstract class AbstractDepartment {

    public abstract void visit(FullTimeEmployee fullTimeEmployee);

    public abstract void visit(PartTimeEmployee partTimeEmployee);

}
