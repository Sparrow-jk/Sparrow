package compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sparrow
 * @description 省市
 * @description Composite
 */
public class Province extends AbstractOrganization {
    private String name;
    List<AbstractOrganization> cities = new ArrayList<>();

    public Province(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractOrganization organization) {
        cities.add(organization);
    }

    @Override
    public void remove(AbstractOrganization organization) {
        cities.remove(organization);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("-----------" + getName() + "-----------");
        // 输出该省里注册的市的名称
        for(AbstractOrganization city : cities){
            city.print();
        }
    }
}
