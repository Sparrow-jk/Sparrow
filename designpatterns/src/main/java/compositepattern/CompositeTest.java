package compositepattern;

/**
 * @author Sparrow
 * @description 测试组合模式
 */
public class CompositeTest {
    public static void main(String[] args) {

        AbstractOrganization country = new Country("中国");

        AbstractOrganization zjProvince = new Province("浙江省");
        AbstractOrganization jsProvince = new Province("江苏省");

        AbstractOrganization hzCity = new City("杭州市");
        AbstractOrganization wzCity = new City("温州市");

        AbstractOrganization njCity = new City("南京市");
        AbstractOrganization szCity = new City("苏州市");

        zjProvince.add(hzCity);
        zjProvince.add(wzCity);

        jsProvince.add(njCity);
        jsProvince.add(szCity);

        country.add(zjProvince);
        country.add(jsProvince);

        country.print();


    }
}
