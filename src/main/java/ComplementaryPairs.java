import java.util.Arrays;
import java.util.List;

public class ComplementaryPairs {
    public static void main(String args[]) {


        int arr[] = {2, 5, -1, 6, 10, -2};
        System.out.println(findKComplementary(arr, 4));
    }


    public static int findKComplementary(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] + A[j] == K) {
                    System.out.println();
                    System.out.print("[" + i + "]");
                    System.out.print("[" + j + "]");
                    count++;
                }
            }
        }
        return count;
    }


}
