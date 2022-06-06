import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import parcs.*;

public class CheckPrimeNumber implements AM {

    private static int Jacobi(int k, int n) {
        if ( k < 0 || n % 2 == 0 ) {
            return 0;
        }
        k %= n;
        int jacobi = 1;
        while ( k > 0 ) {
            while ( k % 2 == 0 ) {
                k /= 2;
                int r = n % 8;
                if ( r == 3 || r == 5 ) {
                    jacobi = -jacobi;
                }
            }
            int temp = n;
            n = k;
            k = temp;
            if ( k % 4 == 3 && n % 4 == 3 ) {
                jacobi = -jacobi;
            }
            k %= n;
        }
        if ( n == 1 ) {
            return jacobi;
        }
        return 0;
    }

    public static boolean IsPrime(int n, int l)
    {
        if (n == 2)
            return true;
        if (n == 3)
            return true;
        if (n % 2 == 0 || n < 2)
            return false;

        for (int i = 0; i < l; ++i)
        {
            int a = (int) (Math.random() * (n - 2)) + 2;
            int x = Jacobi(a, n);
            int s;
            BigInteger S = new BigInteger(String.valueOf(a));
            BigInteger N = new BigInteger(String.valueOf(n));
            s = S.modPow(new BigInteger(String.valueOf((int) Math.floor((n - 1) / 2.0))), N).intValue();
            if ( (x == 0) || ( MyModulo(s, n)   !=   MyModulo(x, n) )      )
                return false;
        }

        return true;
    }

    public static int MyModulo(int n, int m)
    {
        return (((n % m) + m) % m);
    }

    public void run(AMInfo info) {
        FileInput fileInput = (FileInput)info.parent.readObject();
        System.out.println("[" + fileInput.getId() + "] Build started.");

        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();
        int n = 2;
        int interval_length = (fileInput.getEndInterval() - fileInput.getBeginInterval()) / n;
        for (int temp = fileInput.getBeginInterval(); temp < fileInput.getEndInterval(); temp += interval_length)
        {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("CheckPrimeNumber");
            FileInput tempoFileInput = new FileInput(temp, temp + interval_length, fileInput.getPrimeTests());
            c.write(tempoFileInput);
            points.add(p);
            chans.add(c);
        }

        long sum = fileInput.getTime();
        for (channel c: chans) {
            sum += c.readLong();
        }
        try {
            Thread.sleep(fileInput.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("[" + fileInput.getId() + "] Build finished.");
        info.parent.write(sum);
    }

}

