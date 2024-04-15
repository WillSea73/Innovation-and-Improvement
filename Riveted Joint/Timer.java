import java.time.Instant;

public class Timer {
    public static void main(String[] args) {
        Instant timer;
        Instant timePrev;

        for (int i = 0; i < 100000; ++i) {
            timer = Instant.now();
            System.out.println(timer.toString());
        }
    }
}
