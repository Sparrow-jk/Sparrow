package visitorpattern;


public interface Employee {

  void accept(AbstractDepartment handler);
}
