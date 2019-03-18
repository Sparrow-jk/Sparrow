package visitorpattern;

/**
 * 财务部门
 *
 * @author Sparrow
 * @description ConcreteVisitor（具体访问者）
 * @description 具体访问者实现了抽象访问者声明的方法，每一个操作作用于访问对象结构中一种类型的元素。
 */
public class FinanceDepartment extends AbstractDepartment {

    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        String name = fullTimeEmployee.getName();
        int workTime = fullTimeEmployee.getWorkTime();
        double weeklyWage = fullTimeEmployee.getWeeklyWage();

        if (workTime > 40) {
            weeklyWage = weeklyWage + (workTime - 40) * 50;
        } else if (workTime < 40) {
            weeklyWage = weeklyWage - (40 - workTime) * 80;
            if (weeklyWage < 0) {
                weeklyWage = 0;
            }
        }

        System.out.println("正式员工：" + name + "工作时长：" + workTime + "小时," + "工资：" + weeklyWage);

    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {
        String name = partTimeEmployee.getName();
        int workTime = partTimeEmployee.getWorkTime();
        double hourWage = partTimeEmployee.getHourWage();
        System.out.println("零时员工：" + name + "工作时长：" + workTime + "小时," + "工资：" + workTime * hourWage);


    }
}
