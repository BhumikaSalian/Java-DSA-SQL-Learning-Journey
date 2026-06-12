import java.io.IOException;
import java.util.Scanner;

public class Prompt{
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        Runtime run = Runtime.getRuntime();
        System.out.println("Enter the app you wish to open: ");
        String app = scan.next();
        Thread.sleep(5000);
        Process pro = run.exec(app);
    }
}