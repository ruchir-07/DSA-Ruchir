public class ProductArray {

    static void productArray(int[] arr, int n){
        if (n == 0) {
            return;
        }

        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0]=1;
        for (int i=1; i<n; i++){
            leftProduct[i] = leftProduct[i-1] * arr[i-1];
        }

        rightProduct[n-1]=1;
        for (int i=n-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * arr[i+1];
        }

        for (int i=0; i<n; i++){
            arr[i] = leftProduct[i] * rightProduct[i];
        }

        for (int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        int n = arr.length;
        System.out.println("The product array is : ");
        productArray(arr, n);
    }
}
