public class CountInversions {
    static int[] arr = new int[] { 1, 20, 6, 4, 5 };

    static int inversion(int n){
        int invCount=0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j])
                    invCount++;
            }
        }

        return invCount;
    }
    public static void main(String[] args) {
        System.out.println("Number of inversions required will be: " + inversion(arr.length));
    }
}
