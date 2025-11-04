public class subsetSum {
    public static void main(String[] args) {
        int[] wallet = {7,8,5,3,10,9,6};
        int target = 15;
        System.out.println(canPay(wallet,target));
        System.out.println(noOfWays(wallet, target));
    }
    static boolean canPay(int[] w, int target){
        return helper(w,target,0);
    }
    static boolean helper(int[] w, int target, int i){
        if(target==0) return true;
        if(i>=w.length) return false;
        boolean exc = helper(w, target, i+1);
        if(exc) return true;
        boolean inc = helper(w, target-w[i], i+1);
        return  inc;
    }
    static int noOfWays(int[] w, int target){
        return noOfWaysHelper(w, target, 0);
    }
    static int noOfWaysHelper(int[] w, int target, int i){
        if(target==0) return 1;
        if(i>=w.length) return 0;
        int exc = noOfWaysHelper(w, target, i+1);
        int inc = noOfWaysHelper(w, target-w[i], i+1);
        return exc+inc;
    }
}
