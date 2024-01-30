public class pairDiff {

    static void findPair(int[] arr, int n, int diff){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                // If the difference between the
                // two elements is n, print them
                if ((arr[j] - arr[i]) == diff) {
                    System.out.println("Pair Found: (" + arr[i] + ", " + arr[j] + ")");
                    return;
                }
            }
        }

        System.out.println("No such pair");
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 30, 40, 100 };
        int n = arr.length;
        int diff = -60;

        findPair(arr, n, diff);
    }
}
