import java.rmi.*;
import java.rmi.server.*;

public class ProductImpl extends UnicastRemoteObject implements Product {

    public ProductImpl() throws RemoteException {
        super();
    }

    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
}
