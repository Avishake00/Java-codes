package recursion;

public class fibonacci {

    static int printfibo(int a, int b, int n) {

        // base case
        if (n == 0) {

            return b;
        }

        return printfibo(b, a + b, n - 1);

    }

    public static void main(String[] args) {
        System.out.println(printfibo(0, 1, 4));
    }

}
