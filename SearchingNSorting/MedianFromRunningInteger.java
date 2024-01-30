public class MedianFromRunningInteger {
    static int binarySearch(float arr[], float item, int low, int high){
        if(low >= high)
            return (item > arr[low] ? (low+1) : low);

        int mid = (high + low)/2;

        if(item == arr[mid])
            return mid+1;
        if(item > arr[mid])
            return binarySearch(arr, item, mid+1, high);

        return binarySearch(arr, item, low, mid-1);
    }
    static void printMedian(float arr[], int n){
        int i, j, pos;
        float num;
        int count = 1;

        System.out.println("Median after reading 1 element is " + arr[0]);
        for(i=1; i<n; i++){
            float median;
            j=i-1;
            num = arr[i];

            pos = binarySearch(arr, num, 0, j);

            while(j >= pos){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = num;
            count++;

            if(count%2 != 0)
                median = arr[count/2];
            else
                median = (arr[(count/2) - 1] + arr[count/2])/2;

            System.out.println("Median after reading " + (i+1) + " element is " + median);
        }
    }

    public static void main(String[] args) {
        float arr[]
                = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        int n = arr.length;

        printMedian(arr, n);
    }
}
