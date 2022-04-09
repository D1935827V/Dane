import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SelectionSort {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final ArrayList<Integer> sorts = new ArrayList<>();
    private final ArrayList<Integer> comparisons = new ArrayList<>();
    private final ArrayList<Duration> timeElapsed = new ArrayList<>();

    public void run() {
        // Run 12 times to collect data
        for (int T = 0; T < 12; T++) {
            Instant start = Instant.now();
            // statically defining certain parameters like size and variables that are
            // constant across all algo
            int size = 5000;
            for (int i = 0; i < size; i++)
                data.add((int) (Math.random() * (size + 1)));

            // resetting variables before new run
            int s = 0, c = 0, min, minIdx;

            // Selection Sort algorithm here, notice double or loop
            for (int i = 0; i < data.size(); i++) {
                min = data.get(i);
                minIdx = i;

                for (int j = i; j < data.size(); j++) {
                    if (data.get(j) < min) {
                        min = data.get(j);
                        minIdx = j;
                    }
                    c++;
                }

                if (min < data.get(i)) {
                    int temp = data.get(i);
                    data.set(i, data.get(minIdx));
                    data.set(minIdx, temp);
                    s++;
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