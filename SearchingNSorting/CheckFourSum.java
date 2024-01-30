import java.util.HashMap;

public class CheckFourSum {
    static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static void findFourSum(int[] arr, int n, int x){

        // Store sums of all pairs in a hash table
        HashMap<Integer, Pair> mp = new HashMap<Integer, Pair>();
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                mp.put(arr[i] + arr[j], new Pair(i, j));
            }
        }

        // Traverse through all pairs and search for X - (current pair sum).
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                int sum = arr[i] + arr[j];

                if(mp.containsKey(x - sum)){
                    Pair p = mp.get(x-sum);

                    if(p.first != i && p.second != i && p.first != j && p.second != j){
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[p.first] + "," + arr[p.second]);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 1, 2 };
        int n = arr.length;
        int x=91;

        findFourSum(arr, n, x);
    }
}
