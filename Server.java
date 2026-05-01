import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            Product p = new ProductImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("ProductService", p);
            System.out.println("Server Ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
