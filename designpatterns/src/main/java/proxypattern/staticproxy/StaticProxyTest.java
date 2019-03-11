package proxypattern.staticproxy;

/**
 * @author Sparrow
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        SellTicket trainStation = new TrainStation();
        SellTicket organization = new ProxyOrganization(trainStation);
        organization.sellTicket();
    }
}
