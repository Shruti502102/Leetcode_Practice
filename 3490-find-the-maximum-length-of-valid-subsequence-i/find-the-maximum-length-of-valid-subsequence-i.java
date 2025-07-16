class Solution{
    public int maximumLength(int[] nums){
        return Math.max(
            Math.max(pick(nums,0,false),pick(nums,1,false)),
            Math.max(pick(nums,0,true),pick(nums,1,true))
        );
    }
    private int pick(int[] nums,int startParity, boolean alternate){
        int count=0;
        int expected=startParity;
        for(int num: nums){
            if(num % 2== expected){
                count++;
                if(alternate){
                    expected=1-expected;
                }
            }
        }
        return count;
    }
}