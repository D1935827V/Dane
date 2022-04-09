import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class BubbleSort {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final ArrayList<Integer> sorts = new ArrayList<>();
    private final ArrayList<Integer> comparisons = new ArrayList<>();
    private final ArrayList<Duration> timeElapsed = new ArrayList<>();

    public void run() {
        // Run 12 times to collect data
        for (int T = 0; T < 12; T++) {
            Instant start = Instant.now();
            // statically defining certain parameters like size and variables that are
            // constant across all algos
            int size = 5000;
            for (int i = 0; i < size; i++)
                data.add((int) (Math.random() * (size + 1)));

            // resetting variables before new run
            int s = 0, c = 0;

            // bubble sort algorithm here, notice double for loop
            for (int i = 0; i < data.size() - 1; i++) {
                for (int j = 0; j < data.size() - 1 - i; j++) {
                    c++;
                    if (data.get(j) > data.get(j + 1)) {
                        s++;
                        int temp = data.get(j);
                        data.set(j, data.get(j + 1));
                        data.set(j + 1, temp);
                    }
                }
            }

            // time stamps and other data collected
            Instant end = Instant.now();
            sorts.add(s);
            comparisons.add(c);
            timeElapsed.add(Duration.between(start, end));
            data.clear();
        }

        // for all metrics, values are sorted, high/low dropped, and averaged

        SortMetrics.main(sorts, comparisons, timeElapsed);
    }
}
