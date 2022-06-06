import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class FileInput implements Serializable {
    private static int counter = 0;
    int id;
    private int time;
    private int beginInterval;
    private int endInterval;
    private int primeTests;

    public FileInput(int beginInterval, int endInterval, int primeTests) {
        this.id = counter++;
        this.time = 0;
        this.beginInterval = beginInterval;
        this.endInterval = endInterval;
        this.primeTests = primeTests;
    }

    public int getId()
    {
        return id;
    }

    public int getTime() {
        return time;
    }


    public void setTime(int time) {
        this.time = time;
    }

    public int getBeginInterval() {
        return beginInterval;
    }

    public void setBeginInterval(int beginInterval) {
        this.beginInterval = beginInterval;
    }

    public int getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(int endInterval) {
        this.endInterval = endInterval;
    }

    public int getPrimeTests() {
        return primeTests;
    }

    public void setPrimeTests(int primeTests) {
        this.primeTests = primeTests;
    }
}
