public class countTriplets {
    static int arr[] = new int[]{5, 1, 3, 4, 7};

    static int countTriplets(int n, int sum){
        int ans=0;

        for(int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                for (int k=j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] < sum)
                        ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int sum=12;
        System.out.println(countTriplets(arr.length, sum));
    }
}
