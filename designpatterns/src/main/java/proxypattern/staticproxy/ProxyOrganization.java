package proxypattern.staticproxy;

/**
 * @author Sparrow
 * @description 代理机构售票  只有售票功能
 */
public class ProxyOrganization implements SellTicket {

    //被代理的对象
    private SellTicket trainStation;

    public ProxyOrganization(SellTicket trainStation) {
        this.trainStation = trainStation;
    }

    /**
     * 售票
     */
    @Override
    public void sellTicket() {
        System.out.print("在代理机构");
        trainStation.sellTicket();
    }
}
