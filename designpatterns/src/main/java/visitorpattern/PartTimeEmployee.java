package visitorpattern;

/**
 * 兼职员工
 *
 * @author Sparrow
 * @description ConcreteElement（具体元素）
 * @description 具体元素实现了Accept方法，在Accept方法中调用访问者的访问方法以便完成一个元素的操作。
 */
public class PartTimeEmployee implements Employee {

    private String name;
    private double hourWage;
    private int workTime;

    public PartTimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(AbstractDepartment handler) {
        handler.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
