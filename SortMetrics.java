import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;

public class SortMetrics{
    // for all metrics, values are sorted, high/low dropped, and averaged

    public static void main(ArrayList<Integer> sorts, ArrayList<Integer> comparisons, ArrayList<Duration> timeElapsed){
    
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
        for (
    Duration x : timeElapsed)
    timeAverage += x.getNano();

    // results
        System.out.println("Average # of sorts: " + sortAverage / 10.0);
        System.out.println("Average # of comparisons: " + comparisonAverage / 10.0);
        System.out.println("Average # time spent: " + timeAverage / 10.0 + " nanoseconds");
}
}
