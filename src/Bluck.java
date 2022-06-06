import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import parcs.*;

public class Bluck {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("CheckPrimeNumber.jar");
        FileInput fileInput = fromFile(curtask.findFile("input"));

        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("CheckPrimeNumber");
        c.write(fileInput);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readLong());
        curtask.end();
    }

    public static FileInput fromFile(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        int beginInterval = sc.nextInt();
        int endInterval = sc.nextInt();
        int primeTests = sc.nextInt();

        return new FileInput(beginInterval, endInterval, primeTests);
    }
}


