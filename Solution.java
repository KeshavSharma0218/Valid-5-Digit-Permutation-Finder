import java.util.*;

public class Solution {
    
    public static void findLargestValidNumber(int num) {
        int[] digits = new int[5];
        int temp = num;
        
        for (int i = 4; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        List<Integer> permutations = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == i) continue;
                for (int k = 0; k < 5; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < 5; l++) {
                        if (l == i || l == j || l == k) continue;
                        for (int m = 0; m < 5; m++) {
                            if (m == i || m == j || m == k || m == l) continue;
                            
                            int formedNumber = digits[i] * 10000 + digits[j] * 1000 + digits[k] * 100 + digits[l] * 10 + digits[m];
                            permutations.add(formedNumber);
                        }
                    }
                }
            }
        }
        
        Collections.sort(permutations, Collections.reverseOrder());
        
        for (int perm : permutations) {
            if (perm <= 32767) {
                System.out.println(perm);
                return;
            }
        }
        
        System.out.println("EXCEEDS MAX VALUE");
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
