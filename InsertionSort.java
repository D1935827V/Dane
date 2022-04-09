import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort {
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
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(data.get(0));

            // insertion sort algorithm here, notice double for loop
            for (int i = 1; i < data.size(); i++) {
                for (int j = 0; j < arr.size(); j++) {
                    c++;
                    if (data.get(i) < arr.get(j)) {
                        arr.add(j, data.get(i));
                        s++;
                        break;
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
