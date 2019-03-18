package visitorpattern;

/**
 * 人力资源部门
 *
 * @author Sparrow
 * @description ConcreteVisitor（具体访问者）
 * @description 具体访问者实现了抽象访问者声明的方法，每一个操作作用于访问对象结构中一种类型的元素。
 */
public class HrDepartment extends AbstractDepartment {

    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        int workTime = fullTimeEmployee.getWorkTime();
        String name = fullTimeEmployee.getName();
        System.out.println("正式员工：" + name + "工作时长：" + workTime + "小时");
        if (workTime > 40) {
            System.out.println("正式员工：" + name + "加班时长：" + (workTime-40) + "小时");
        }else if (workTime<40){
            System.out.println("正式员工：" + name + "请假时长：" + (40-workTime) + "小时");
        }

    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {

        int workTime = partTimeEmployee.getWorkTime();
        String name = partTimeEmployee.getName();
        System.out.println("临时员工：" + name + "工作时长：" + workTime + "小时");

    }
}
