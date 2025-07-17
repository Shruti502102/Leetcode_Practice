class Solution {
    public int maximumLength(int[] nums, int k) {
        int maxLength=1;
        for(int val=0;val<k;val++){
            int[] dp=new int[k];
            for(int num: nums){
                int xmod=num%k;
                int needed=(val-xmod+k)%k;
                dp[xmod]=Math.max(dp[xmod],dp[needed]+1);
            }
            for(int length:dp){
                maxLength=Math.max(maxLength,length);
            }
        }    
        return maxLength;
        
    }
}