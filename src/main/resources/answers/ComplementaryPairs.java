public class ComplementaryPairs {
    public static void main(String args[]) {


        int arr[] = {2, 5, -1, 6, 10, -2};
        findKComplementary(arr, 4);
    }


    public static void findKComplementary(int[] A, int K) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] + A[j] == K) {
                    System.out.print("[" + i + "]");
                    System.out.println("[" + j + "]");
                }
            }
        }
    }



}
