package compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sparrow
 * @description 国家
 * @description Composite
 */
public class Country extends AbstractOrganization {

    private String name;
    List<AbstractOrganization> provinces = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractOrganization organization) {
        provinces.add(organization);
    }

    @Override
    public void remove(AbstractOrganization organization) {
        provinces.remove(organization);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("-----------" + getName() + "-----------");
        // 输出该国家注册的省的名称
        for(AbstractOrganization province : provinces){
            province.print();
        }
    }
}
