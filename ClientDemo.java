import java.rmi.*;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            Price p = (Price) Naming.lookup("rmi://localhost/PriceService");
            System.out.println("Selling Price = Rs. " + p.sellingPrice());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
