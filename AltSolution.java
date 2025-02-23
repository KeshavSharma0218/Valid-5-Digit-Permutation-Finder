import java.util.*;

public class AltSolution {
    public static void findLargestValidNumber(int num) {
        int[] digits = new int[5];
        int temp = num;
        
        for (int i = 4; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        Arrays.sort(digits);
        reverseArray(digits);
        do {
            int newValue = getNumberFromDigits(digits);
            if (newValue <= 32767) {
                System.out.println(newValue);
                return;
            }
        } while (prevPermutation(digits));
        System.out.println("EXCEEDS MAX VALUE");
    }
    private static int getNumberFromDigits(int[] digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }
    private static boolean prevPermutation(int[] digits) {
        int i = digits.length - 2;
        while (i >= 0 && digits[i] <= digits[i + 1]) {
            i--;
        }
        if (i == -1) return false;

        int j = digits.length - 1;
        while (digits[j] >= digits[i]) {
            j--;
        }

        swap(digits, i, j);
        reverseArray(digits, i + 1);
        return true;
    }
    private static void reverseArray(int[] arr) {
        reverseArray(arr, 0);
    }
    private static void reverseArray(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        while (console.hasNextInt()) {
            int num = console.nextInt();
            if (num < 10000 || num >= 100000) continue;
            findLargestValidNumber(num);
        }
        
        console.close();
    }
}
