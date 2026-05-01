import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

// Remote Interface
interface Greater extends Remote {
    int findGreater(int a, int b) throws RemoteException;
}

// Server Implementation
class GreaterImpl extends UnicastRemoteObject implements Greater {
    protected GreaterImpl() throws RemoteException { super(); }

    public int findGreater(int a, int b) throws RemoteException {
        return (a > b) ? a : b;
    }
}

// Main Class (Server + Client)
public class GreaterRMI {
    public static void main(String[] args) {
        try {
            // 🔥 CREATE REGISTRY (IMPORTANT)
            LocateRegistry.createRegistry(1099);

            // ---------- SERVER PART ----------
            GreaterImpl obj = new GreaterImpl();
            Naming.rebind("greaterService", obj);
            System.out.println("Server started...");

            // ---------- CLIENT PART ----------
            Greater stub = (Greater) Naming.lookup("rmi://localhost/greaterService");

            int a = 2500;
            int b = 250;

            int result = stub.findGreater(a, b);
            System.out.println("Greater number is: " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
