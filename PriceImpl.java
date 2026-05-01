import java.rmi.*;
import java.rmi.server.*;

public class PriceImpl extends UnicastRemoteObject implements Price {

    public PriceImpl() throws RemoteException {
        super();
    }

    public int sellingPrice() throws RemoteException {
        int costPrice = 5000;
        int discount = 50;
        return costPrice - discount;
    }
}
