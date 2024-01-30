import java.util.*;

class countSort{

    public static int[] countSort(int[] arr){
        int n = arr.length;
        int m=0;

        for(int i = 0; i < n; i++){
            m = Math.max(m, arr[i]);
        }

        int countArray[] = new int[m+1];

        for(int i = 0; i < n; i++){
            countArray[arr[i]]++;
        }

        for(int i = 1; i <= m; i++){
            countArray[i] += countArray[i-1];
        }

        int[] outputArray = new int[n];

        for(int i=n-1; i>=0; i--){
            outputArray[countArray[arr[i]] - 1] = arr[i];
            countArray[arr[i]]--;
        }

        return outputArray;
    }

    public static void main(String args[]){
        int arr[] = {4, 3, 12, 1, 5, 5, 3, 9};
        int outputArray[] = countSort(arr);

        for(int i = 0; i < outputArray.length; i++){
            System.out.print(outputArray[i] + " ");
        }
    }
}