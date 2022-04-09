import java.util.Scanner;


public class C3 {

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                ("1: Bubble Sort\n2: Selection Sort\n3: Insertion Sort\n4: Merge Sort"));
        int algo = scanner.nextInt();

        // Simple switch statement to call the function for the specified algorithm
        switch (algo) {
            case 1:
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.run();
                break;
            case 2:
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.run();
                break;
            case 3:
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.run();
                break;
            case 4:
                MergeSort mergeSort = new MergeSort();
                mergeSort.run();
                break;
        }
    }
}