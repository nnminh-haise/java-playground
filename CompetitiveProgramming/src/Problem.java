import java.util.Scanner;

public class Problem {
    public static void Recursion(int index, int n, int[] counter, int[] values) {
        if (index == n) {
            for (int i = 0; i < n; ++i) {
                System.out.print(values[i]);
                if (i < n - 1) {
                    System.out.print(", ");
                }
                else {
                    System.out.println();
                }
            }
        }
        else {
            for (int digit = 0; digit <= 9; digit++) {
                if (counter[digit] > 0) {
                    counter[digit] -= 1;
                    values[index] = digit;
                    Recursion(index + 1, n, counter, values);
                    counter[digit] += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
        int number = 1221;
        scanner.close();
        int[] counter = new int[10];
        int numberLength = 0;
        while (number > 0) {
            numberLength++;
            counter[number % 10]++;
            number /= 10;
        }
        int[] values = new int[numberLength];

        Recursion(0, numberLength, counter, values);
    }
}