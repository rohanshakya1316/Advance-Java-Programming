import java.rmi.*;

public interface Price extends Remote {
    int sellingPrice() throws RemoteException;
}
