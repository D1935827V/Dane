import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MergeSort {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final ArrayList<Integer> sorts = new ArrayList<>();
    private final ArrayList<Integer> comparisons = new ArrayList<>();
    private final ArrayList<Duration> timeElapsed = new ArrayList<>();
    int c = 0, s = 0;

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

       SortMetrics.main(sorts, comparisons, timeElapsed);
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

        int[] l = new int[lSize], r = new int[rSize];
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