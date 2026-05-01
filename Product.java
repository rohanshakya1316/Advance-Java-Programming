import java.rmi.*;

public interface Product extends Remote {
    int multiply(int a, int b) throws RemoteException;
}
