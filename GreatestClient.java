import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GreatestClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            dos.writeInt(a);
            dos.writeInt(b);

            int greatest = dis.readInt();
            System.out.println("Greatest number is: " + greatest);

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
