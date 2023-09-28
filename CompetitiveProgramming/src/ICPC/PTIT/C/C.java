package ICPC.PTIT.C;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(scanner.nextInt());
        }
        scanner.close();

        arr.sort((a, b) -> {
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
            return 0;
        });

        int result = 0;
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < arr.size(); ++i) {
            temp += arr.get(i);
            if (temp <= 350) {
                result += temp;
                ++counter;
            }
        }
        System.out.println(counter + " " + result);
    }
}
