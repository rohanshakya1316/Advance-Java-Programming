import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            Product p = (Product) Naming.lookup("rmi://localhost/ProductService");
            System.out.println("Product = " + p.multiply(15, 24));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
