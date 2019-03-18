package visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工集合处理
 *
 * @author Sparrow
 * @description ObjectStructure（对象结构）
 * @description 对象结构是一个元素的集合，用于存放元素对象，且提供便利其内部元素的方法。
 */
public class EmployeeList {

    private List<Employee> employees = new ArrayList<>();

    public void AddEmployee(Employee employee) {
        employees.add(employee);
    }

    public void accept(AbstractDepartment handler) {
        for (Employee employee : employees) {
            employee.accept(handler);
        }
    }

}

