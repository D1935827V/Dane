public record Matrix(int[][] matrix) {
    // store matrix

    // Hack: create toString method using nested for loops to format output of a matrix
    public String toString() {//overriding the toString() method
        StringBuilder reverse_str = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                reverse_str.insert(0, anInt);
                str.append(anInt);
            }
            str.append("\n");
            reverse_str.insert(0, "\n");
        }
        str.append(reverse_str).append("\n");
        return str.toString();
    }

    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{{0, 1},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
    }

    // tester method for matrix formatting
    public static void main() {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);

        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
    }

}
