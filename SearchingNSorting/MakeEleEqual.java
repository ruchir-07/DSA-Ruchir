import java.util.Arrays;

public class MakeEleEqual {

    static int minCostToMakeArrayEqual(int[] a, int n){
        int y;

        // If there are odd elements, we choose middle element
        if(n%2 == 1)
            y=a[n/2];

        // If there are even elements, then we choose the average of middle two.
        else
            y = (a[n/2] + a[(n-2)/2]) / 2;

        int s=0;

        for(int i=0; i<n; i++)
            s+=Math.abs(a[i] - y);

        return s;
    }

    public static void main(String[] args) {
        int[] a = { 1, 100, 101 };
        Arrays.sort(a);
        int n = a.length;
        System.out.println(minCostToMakeArrayEqual(a, n));
    }
}
