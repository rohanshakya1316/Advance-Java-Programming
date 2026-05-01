import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Scanner;

// RMI Interface
interface Factorial extends Remote {
    long calculateFactorial(int n) throws RemoteException;
}

// Server Implementation
class FactorialImpl extends UnicastRemoteObject implements Factorial {
    protected FactorialImpl() throws RemoteException { super(); }

    public long calculateFactorial(int n) throws RemoteException {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }
}

// Main class to run server and client
public class FactorialRMI {

    public static void main(String[] args) {
        try {
            // Start RMI registry
            LocateRegistry.createRegistry(1099);

            // Bind the remote object
            FactorialImpl obj = new FactorialImpl();
            Naming.rebind("rmi://localhost/FactorialService", obj);
            System.out.println("RMI Server is running...");

            // Client logic
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            Factorial remoteObj = (Factorial) Naming.lookup("rmi://localhost/FactorialService");
            long result = remoteObj.calculateFactorial(n);

            System.out.println("Factorial of " + n + " is: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
