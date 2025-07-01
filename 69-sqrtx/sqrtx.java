class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        int l=0;
        int r=x;
        int a=0;
        while(l<=r){
            int mid=(l+r)/2;
            long sq=(long)mid*mid;
            if(sq==x){
                return mid;
            }
            else if(sq<x){
                a=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return a;
    }
}