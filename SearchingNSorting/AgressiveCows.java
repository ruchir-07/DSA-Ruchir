import java.util.Arrays;

public class AgressiveCows {
    static boolean isPossible(int[] arr, int k, int median){
        int cows = 1;
        int lastPositionCow = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] - lastPositionCow >= median){
                cows++;
                lastPositionCow = arr[i];
                if(cows >= k)
                    return true;
            }
        }

        return false;
    }
    static int aggressiveCows(int[] arr, int n, int k){
        Arrays.sort(arr);

        int low = 1;
        int high = arr[n-1];
        int median = 0;

        while (low <= high){
            median = (low+high)/2;

            if(isPossible(arr, k, median)){
                low = median+1;
            }
            else
                high = median-1;
        }

        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int k=3, n= arr.length;

        int minDist = aggressiveCows(arr, n, k);

        System.out.println(minDist);
    }
}
