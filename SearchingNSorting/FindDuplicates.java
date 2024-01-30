import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class FindDuplicates {
    // Increment array elements by 1
    static ArrayList<Integer> duplicate(int[] arr, int n){
        for(int i=0; i<n; i++){
            arr[i] += 1;
        }

        ArrayList<Integer> result = new ArrayList<>();

        // count variable for count of largest element
        int count=0;

        // Calculate index value
        for(int i=0; i<n; i++) {
            int index = Math.abs(arr[i] > n ? Math.abs(arr[i] / (n + 1)) : Math.abs(arr[i]));

            // Check if index equals largest element value
            if (index == n) {
                count++;
                continue;
            }

            // Get Element value at Index
            int val = arr[index];

            // Check if element value is negative, positive or greater than n
            if (val < 0) {
                result.add(index - 1);
                arr[index] = Math.abs(arr[index] * (n + 1));
            } else if (val > n)
                continue;
            else
                arr[index] = -arr[index];
        }

        // If largest element occurs more than once
        if(count > 1)
            result.add(n-1);

        if(result.size() == 0)
            result.add(-1);
        else
            Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
        int n = numRay.length;
        ArrayList<Integer> ans = duplicate(numRay, n);
        for(int i : ans)
            System.out.println(i);
    }
}
