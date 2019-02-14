package mediatorpattern;

public class MediatorStructure implements Mediator {

    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, AbstractCharacter character) {
        //如果是房主，则租房者获得信息
        if (character == houseOwner) {
            tenant.getMessage(message);
            //否则是房主获得信息
        } else {
            houseOwner.getMessage(message);
        }
    }
}
