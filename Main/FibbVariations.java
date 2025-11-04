import java.util.*;

public class FibbVariations {
    static long[] dp = new long[101];
    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        System.out.println(fib(60));
        System.out.println(betterFib(60));
    }
    static long fib(long n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[(int)n] != -1) return dp[(int)n];
        return dp[(int)n] = fib(n-1)+fib(n-2);
    }
    static long betterFib(long n){
        long[] d = new long[101];
        d[0]=0; d[1]=1;
        for(int i=2;i<d.length;i++)
            d[i]=d[i-1]+d[i-2];
        return d[(int)n];
    }
}
