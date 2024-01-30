public class maximumSubsequence {
    static int findMaxSum(int arr[], int n){
        int incl = arr[0];
        int excl=0;
        int excl_new;

        for(int i=1; i<n; i++){
            excl_new = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = excl_new;
        }

        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 10, 100, 10, 5 };
        int N = 6;

        // Function call
        System.out.println(findMaxSum(arr, N));    }
}
