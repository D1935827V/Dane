import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort {
    // statically defining certain parameters like size and variables that are
    // constant across all algos
    private final int size = 5000;
    private ArrayList<Integer> data = new ArrayList<>(), sorts = new ArrayList<>(), comparisons = new ArrayList<>();
    private ArrayList<Duration> timeElapsed = new ArrayList<>();

    public void run() {
        // Run 12 times to collect data
        for (int T = 0; T < 12; T++) {
            Instant start = Instant.now();
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

        sorts.sort(Comparator.naturalOrder());
        sorts.remove(0);
        sorts.remove(sorts.size() - 1);

        double sortAverage = 0;
        for (int x : sorts)
            sortAverage += (double) x;

        comparisons.sort(Comparator.naturalOrder());
        comparisons.remove(0);
        comparisons.remove(comparisons.size() - 1);

        double comparisonAverage = 0.0;
        for (int x : comparisons)
            comparisonAverage += (double) x;

        timeElapsed.sort(Comparator.naturalOrder());
        timeElapsed.remove(0);
        timeElapsed.remove(timeElapsed.size() - 1);

        double timeAverage = 0;
        for (Duration x : timeElapsed)
            timeAverage += (x.getNano());

        // results
        System.out.println("Average # of sorts: " + sortAverage / 10.0);
        System.out.println("Average # of comparisons: " + comparisonAverage / 10.0);
        System.out.println("Average # time spent: " + timeAverage / 10.0 + " nanoseconds");
    }
}
