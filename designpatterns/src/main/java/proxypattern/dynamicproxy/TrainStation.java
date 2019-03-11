package proxypattern.dynamicproxy;


/**
 * @author Sparrow
 * @description 火车站售票 火车站不只售票 还有其他功能
 */
public class TrainStation implements SellTicket {

    /**
     * 售票
     */
    @Override
    public void sellTicket() {
        System.out.println("出售火车票");
    }
}
