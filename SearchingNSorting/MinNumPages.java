public class MinNumPages {

    static boolean isPossible(int[] arr, int m, int n, int curr_min){
        int students_required = 1;
        int curr_sum = 0;

        for(int i=0; i<n; i++){
            curr_sum += arr[i];
            if (curr_sum > curr_min){
                students_required++;
                curr_sum = arr[i];
            }
        }

        return students_required <= m;
    }
    static int findPages(int[] arr, int n, int m){
        int sum = 0;

        // return -1 if no. of books is less than no. of students
        if(n < m)
            return -1;
        int max = arr[0];

        // Count total number of pages
        for (int i=0; i<n; i++){
            sum += arr[i];
            max = (arr[i] > max) ? arr[i] : max;
        }

        // initialize start as arr[n-1] pages(minimum answer possible) and end as total pages
        // (maximum answer possible)
        int start=arr[n-1], end=sum;
        int result = Integer.MAX_VALUE;

        while(start <= end){
            // check if it is possible to distribute books by using mid is current minimum
            int mid = start + (end-start)/2;
            if(isPossible(arr, m, n, mid)){
                // update result to current distribution as it's the best we have found till now.
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 67, 90 };
        int m = 2;

        System.out.println("Minimum number of pages " + findPages(arr, arr.length, m));
    }
}
