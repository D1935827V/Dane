import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    // statically defining certain parameters like size and variables that are
    // constant across all algos
    private final int size = 5000;
    private ArrayList<Integer> data = new ArrayList<>(), sorts = new ArrayList<>(), comparisons = new ArrayList<>();
    private ArrayList<Duration> timeElapsed = new ArrayList<>();
    int c = 0, s = 0;

    public void run() {
        // Run 12 times to collect data
        for (int T = 0; T < 12; T++) {
            Instant start = Instant.now();
            for (int i = 0; i < size; i++)
                data.add((int) (Math.random() * (size + 1)));

            // resetting variables before new run
            c = 0;
            s = 0;
            // merge sort algorithm here, notice binary search style
            mergeSort(0, size - 1);

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
            timeAverage += x.getNano();

        // results
        System.out.println("Average # of sorts: " + sortAverage / 10.0);
        System.out.println("Average # of comparisons: " + comparisonAverage / 10.0);
        System.out.println("Average # time spent: " + timeAverage / 10.0 + " nanoseconds");
    }

    public void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    public void merge(int left, int middle, int right) {
        int lSize = middle - left + 1, rSize = right - middle;

        int l[] = new int[lSize], r[] = new int[rSize];
        for (int i = 0; i < lSize; i++)
            l[i] = data.get(left + i);
        for (int i = 0; i < rSize; i++)
            r[i] = data.get(middle + 1 + i);

        int i = 0, j = 0, k = 1;
        while (i < lSize && j < rSize) {
            c++;
            if (l[i] <= r[j]) {
                data.set(k, l[i]);
                s++;
                i++;
            } else {
                data.set(k, r[j]);
                s++;
                j++;
            }
            k++;
        }

        while (i < lSize) {
            data.set(k, l[i]);
            c++;
            s++;
            i++;
            k++;
        }

        while (j < rSize) {
            data.set(k - 1, r[j]);
            c++;
            s++;
            j++;
            k++;
        }
    }
}