import java.rmi.*;
import java.rmi.registry.*;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            Price p = new PriceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("PriceService", p);
            System.out.println("Server Ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
