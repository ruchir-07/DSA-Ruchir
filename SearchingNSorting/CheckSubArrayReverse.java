// Check if reversing a sub array make the array sorted
import java.util.Arrays;

public class CheckSubArrayReverse {
    static boolean checkReverse(int[] arr, int n){
        // copying all the elements to a temporary array
        int temp[] = new int[n];
        for(int i=0; i<n; i++){
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        // Find the first mismatch
        int front;
        for(front=0; front<n; front++){
            if(temp[front] != arr[front])
                break;
        }

        //Find the last Mismatch
        int back;
        for(back=n-1; back>=0; back--){
            if(temp[back] != arr[back])
                break;
        }

        // If whole array is sorted
        if(front >= back)
            return true;

        // Checking subarray is missing or not
        do {
            front++;
            if (arr[front-1] < arr[front])
                return false;
        }while(front != back);

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 4};
        int n = arr.length;

        if(checkReverse(arr, n))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
