public class IntByReference {
    private int value;

    public IntByReference(int n) {
        this.value = n;
    }

    public static void swapToLowHighOrder(IntByReference a,IntByReference b) {
    int num1 = a.value;
    int num2 = b.value;
    if (num2>num1) {
        a.value = num2;
        b.value = num1;
        }
    }

    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        swapToLowHighOrder(a, b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    public String toString(){//overriding the toString() method
        return ""+value;
    }

    // static main method that provides some simple test cases
    public static void main() {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}