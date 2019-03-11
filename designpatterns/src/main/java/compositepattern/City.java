package compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sparrow
 * @description 省会城市
 * @description Leaf
 */
public class City extends AbstractOrganization {
    private String name;

    public City(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
