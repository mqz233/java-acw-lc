package _24sep;

public class LC50 {
    public double myPow(double x, int n) {
        boolean flag = false;
        if(n < 0 ) flag = true;
        n = Math.abs(n);
        double res =1;
        double mul =x;
        while(n!=0){
            res = res * (n%2==0?1:mul);
            mul = mul * x;
            n = n/2;
        }
        return flag?1/res:res;
    }

    public static void main(String[] args) {
        LC50 lc50 = new LC50();
        lc50.myPow(2,10);
    }
}
